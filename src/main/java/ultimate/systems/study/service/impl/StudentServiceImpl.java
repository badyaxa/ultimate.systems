package ultimate.systems.study.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ultimate.systems.study.model.Student;
import ultimate.systems.study.model.Teacher;
import ultimate.systems.study.repository.StudentRepository;
import ultimate.systems.study.repository.TeacherRepository;
import ultimate.systems.study.service.StudentService;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find a student by Id: " + id));
    }

    @Override
    public List<Student> findAll(PageRequest pageRequest) {
        return studentRepository.findAll(pageRequest).stream().collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)
                .orElseThrow(
                        () -> new RuntimeException("Can't find a student by first name: "
                                + firstName + " and last name: " + lastName));
    }

    @Override
    public List<Student> findAllByTeacherId(Long teacherId/*, PageRequest pageRequest*/) {
        return studentRepository.findStudentsByTeachersId(teacherId);
    }

    @Override
    public Set<Teacher> addTeacher(Long studentId, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(
                        () -> new RuntimeException("Can't find a teacher by Id: "
                        + teacherId));
        Student student = findById(studentId);
        student.addTeacher(teacher);
        studentRepository.save(student);
        return student.getTeachers();
    }
}
