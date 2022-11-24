package ultimate.systems.study.service;

import java.util.List;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import ultimate.systems.study.model.Student;
import ultimate.systems.study.model.Teacher;

public interface StudentService {
    Student save(Student student);

    Student findById(Long id);

    void delete(Long id);

    List<Student> findAll(PageRequest pageRequest);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findAllByTeacherId(Long teacherId);

    Set<Teacher> addTeacher(Long studentId, Long teacherId);
}
