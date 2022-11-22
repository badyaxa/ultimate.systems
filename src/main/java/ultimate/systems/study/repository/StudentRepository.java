package ultimate.systems.study.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ultimate.systems.study.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName,
                                                                     String lastName);

    List<Student> findStudentsByTeachersId(Long teacherId);
}
