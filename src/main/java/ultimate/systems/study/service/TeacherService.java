package ultimate.systems.study.service;

import java.util.List;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import ultimate.systems.study.model.Student;
import ultimate.systems.study.model.Teacher;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher findById(Long id);

    void delete(Long id);

    List<Teacher> findAll(PageRequest pageRequest);

    Teacher findByFirstNameAndLastName(String firstName, String lastName);

    List<Teacher> findAllByStudentId(Long studentId/*, PageRequest pageRequest*/);

    Set<Student> addStudent(Long teacherId, Long studentId);

    public void removeStudent(Long teacherId, Long studentId);
}
