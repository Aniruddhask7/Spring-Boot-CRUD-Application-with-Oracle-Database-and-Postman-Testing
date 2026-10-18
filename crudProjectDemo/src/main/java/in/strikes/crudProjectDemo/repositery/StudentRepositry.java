package in.strikes.crudProjectDemo.repositery;


import in.strikes.crudProjectDemo.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentRepositry extends JpaRepository<student , Long> {

    Optional<student> findByIdAndDeletedIsFalse(Long id);
    List<student> findByDeletedIsFalse();


}
