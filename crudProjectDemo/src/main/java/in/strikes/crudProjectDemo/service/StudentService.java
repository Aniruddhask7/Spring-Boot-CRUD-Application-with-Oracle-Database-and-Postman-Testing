package in.strikes.crudProjectDemo.service;

import in.strikes.crudProjectDemo.entity.student;
import in.strikes.crudProjectDemo.repositery.StudentRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

private StudentRepositry studRepositry;
public StudentService(StudentRepositry studRepositry){
    this.studRepositry = studRepositry;
}


//crreate
    public student createStudent(student studRequest){

        student studRespo =  studRepositry.save(studRequest);

        return studRespo;

    }


    //read
    public student getStudent(Long id){

       Optional<student> studResponse =  studRepositry.findById(id);

       if(studResponse.isPresent()){
           return studResponse.get();
       }
       return null;
    }


    //readAll

    public List<student> getAllStudent(){
        List<student> studRespons =  studRepositry.findAll();


      return studRespons;
        }


        //update

    public student updareStudent(Long id   , student stdRequest){
       Optional<student> existingStudent =  studRepositry.findById(id);

      if(existingStudent.isEmpty()){
          return null;
      }


      student studentToSave = existingStudent.get();
      studentToSave.setName(stdRequest.getName());
      studentToSave.setEmail(stdRequest.getEmail());
      studentToSave.setAge(stdRequest.getAge());
      studentToSave.setRollNo(stdRequest.getRollNo());
      studentToSave.setSubject(stdRequest.getSubject());

      return  studRepositry.save(studentToSave);


    }



    public Boolean deleteStudent(Long id){
      Boolean studRespo = studRepositry.existsById(id);

     if(!studRespo) {
         return false;
     }

     studRepositry.deleteById(id);

        return true;

    }

}
