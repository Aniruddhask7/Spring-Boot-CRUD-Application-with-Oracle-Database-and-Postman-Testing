package in.strikes.crudProjectDemo.service;

import in.strikes.crudProjectDemo.entity.student;
import in.strikes.crudProjectDemo.repositery.StudentRepositry;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.MediaTypeFileExtensionResolver;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final MediaTypeFileExtensionResolver mediaTypeFileExtensionResolver;
    private StudentRepositry studRepositry;
public StudentService(StudentRepositry studRepositry, MediaTypeFileExtensionResolver mediaTypeFileExtensionResolver){
    this.studRepositry = studRepositry;
    this.mediaTypeFileExtensionResolver = mediaTypeFileExtensionResolver;
}


//create
    public student createStudent(student studRequest){

    studRequest.setDeleted(false);
        student studRespo =  studRepositry.save(studRequest);
        return studRespo;



    }


    //read
    public student getStudent(Long id){
//                                         select * from student where id =1 and  deleted = false;
       Optional<student> studResponse =  studRepositry.findByIdAndDeletedIsFalse(id);
        //findById(id)
       if(studResponse.isPresent()){
           return studResponse.get();
       }
       return null;
    }


    //readAll

    public List<student> getAllStudent(){
        List<student> studRespons =  studRepositry.findByDeletedIsFalse();
 //findAll()

      return studRespons;
        }


        //update

    public student updareStudent(Long id   , student stdRequest){
       Optional<student> existingStudent =  studRepositry.findByIdAndDeletedIsFalse(id);

      if(existingStudent.isEmpty()){
          return null;
      }



      student studentToSave = existingStudent.get();
      studentToSave.setName(stdRequest.getName());
      studentToSave.setEmail(stdRequest.getEmail());
      studentToSave.setAge(stdRequest.getAge());
      studentToSave.setRollNo(stdRequest.getRollNo());
      studentToSave.setSubject(stdRequest.getSubject());
      studentToSave.setDeleted(false);

      return  studRepositry.save(studentToSave);


    }


     //delete
    public  Boolean deleteStudent(Long id){
      Boolean studRespo = studRepositry.existsById(id);

     if(!studRespo) {
         return false;
     }

     studRepositry.deleteById(id);

        return true;

    }



    //soft deleted  patch
    public Boolean deletSoftStudent(Long id){
        Optional<student> existingStudent =  studRepositry.findByIdAndDeletedIsFalse(id);


        if(existingStudent.isEmpty()){
            return false;
        }



        student studentTosave = existingStudent.get();

        studentTosave.setDeleted(true);

        studRepositry.save(studentTosave);


        return true;





    }

}
