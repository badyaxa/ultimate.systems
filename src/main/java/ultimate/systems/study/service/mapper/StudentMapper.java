package ultimate.systems.study.service.mapper;

import org.springframework.stereotype.Component;
import ultimate.systems.study.dto.request.StudentRequestDto;
import ultimate.systems.study.dto.response.StudentResponseDto;
import ultimate.systems.study.model.Student;

@Component
public class StudentMapper implements ResponseDtoMapper<StudentResponseDto, Student>,
        RequestDtoMapper<StudentRequestDto, Student> {

    @Override
    public Student mapToModel(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setEmail(studentRequestDto.getEmail());
        student.setDirection(studentRequestDto.getDirection());
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setDirection(student.getDirection());
        return studentResponseDto;
    }
}
