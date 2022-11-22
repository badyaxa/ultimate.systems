package ultimate.systems.study.service.mapper;

import org.springframework.stereotype.Component;
import ultimate.systems.study.dto.request.TeacherRequestDto;
import ultimate.systems.study.dto.response.TeacherResponseDto;
import ultimate.systems.study.model.Teacher;

@Component
public class TeacherMapper implements ResponseDtoMapper<TeacherResponseDto, Teacher>,
        RequestDtoMapper<TeacherRequestDto, Teacher> {

    @Override
    public Teacher mapToModel(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDto.getFirstName());
        teacher.setLastName(teacherRequestDto.getLastName());
        teacher.setAge(teacherRequestDto.getAge());
        teacher.setEmail(teacherRequestDto.getEmail());
        teacher.setSubject(teacherRequestDto.getSubject());
        return teacher;
    }

    @Override
    public TeacherResponseDto mapToDto(Teacher teacher) {
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
        teacherResponseDto.setId(teacher.getId());
        teacherResponseDto.setFirstName(teacher.getFirstName());
        teacherResponseDto.setLastName(teacher.getLastName());
        teacherResponseDto.setAge(teacher.getAge());
        teacherResponseDto.setEmail(teacher.getEmail());
        teacherResponseDto.setSubject(teacher.getSubject());
        return teacherResponseDto;
    }
}
