package in.strikes.crudProjectDemo.repositery;


import in.strikes.crudProjectDemo.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepositry extends JpaRepository<student , Long> {


}
