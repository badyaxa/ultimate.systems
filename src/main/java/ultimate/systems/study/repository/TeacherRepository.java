package ultimate.systems.study.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ultimate.systems.study.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName,
                                                                     String lastName);

    List<Teacher> findTeachersByStudentsId(Long studentId);
}
