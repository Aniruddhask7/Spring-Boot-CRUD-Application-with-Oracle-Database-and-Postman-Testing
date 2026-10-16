package in.strikes.crudProjectDemo.controller;


import in.strikes.crudProjectDemo.entity.student;
import in.strikes.crudProjectDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {


private StudentService studService;
public StudentController (StudentService studService){
    this.studService = studService;
}


    //create
    @PostMapping("/create")   //if you want to add full url then use this otherwise no


    public ResponseEntity<student> createStudent(@RequestBody student std){

        student createdStudent =   studService.createStudent(std);

  return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
         //return ResponseEntity.ok(createdStudent);
        // return ResponseEntity.status(404).body(createdStudent);
  }



  //read
 @GetMapping("/get/{id}")
    public ResponseEntity<student>getStudent(@PathVariable Long id){

        student studRespons = studService.getStudent(id);

        if(studRespons == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studRespons);
//        return ResponseEntity.status(HttpStatus.OK).body(studRespons);
    }

    //real all
    @GetMapping("/getAll")
    public ResponseEntity<List<student>>getAllStudent(){
        List<student> studResponse =  studService.getAllStudent();



        if(studResponse == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studResponse);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<student>updateStudent(@PathVariable Long id , @RequestBody  student stdRequest){

        student studRespo = studService.updareStudent(id ,stdRequest);

        if(studRespo ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studRespo);
        }
        return ResponseEntity.ok(studRespo);
    }



    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteStudent(@PathVariable long id){

        Boolean isDeleted = studService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

      return ResponseEntity.ok("Record is deleted");

    }


}
