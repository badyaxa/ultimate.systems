package ultimate.systems.study.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ultimate.systems.study.dto.request.TeacherRequestDto;
import ultimate.systems.study.dto.response.StudentResponseDto;
import ultimate.systems.study.dto.response.TeacherResponseDto;
import ultimate.systems.study.model.Student;
import ultimate.systems.study.model.Teacher;
import ultimate.systems.study.service.StudentService;
import ultimate.systems.study.service.TeacherService;
import ultimate.systems.study.service.mapper.StudentMapper;
import ultimate.systems.study.service.mapper.TeacherMapper;
import ultimate.systems.study.util.Parser;

@RestController
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    @ApiOperation(value = "Create a new teacher")
    public TeacherResponseDto add(@RequestBody @Valid TeacherRequestDto dto) {
        return teacherMapper.mapToDto(teacherService
                .save(teacherMapper.mapToModel(dto)));
    }

    @PostMapping("/{teacherId}/students/{studentId}")
    @ApiOperation(value = "Add a student to a teacher")
    public Set<StudentResponseDto> addStudent(@PathVariable(value = "teacherId") Long teacherId,
                                              @PathVariable(value = "studentId") Long studentId) {
        return teacherService.addStudent(teacherId, studentId).stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toSet());
    }

    @GetMapping("/by-full-name")
    @ApiOperation(value = "Get a teacher by first name and last name")
    public TeacherResponseDto findByFirstAndLastName(@RequestParam String firstName,
                                                     @RequestParam String lastName) {
        return teacherMapper.mapToDto(
                teacherService.findByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a teacher by id")
    public TeacherResponseDto get(@PathVariable(value = "id") Long id) {
        return teacherMapper.mapToDto(teacherService.findById(id));
    }

    @GetMapping("/{teacherId}/students")
    @ApiOperation(value = "Get a sorted list of all students by teacher ID")
    public List<StudentResponseDto> getAllStudentsByTeacherId(
            @PathVariable(value = "teacherId") Long teacherId) {
        teacherService.findById(teacherId);
        List<Student> students = studentService.findAllByTeacherId(teacherId);
        return students.stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    @ApiOperation(value = "Get a sorted list of teachers by parameters")
    public List<TeacherResponseDto> findAll(@RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "10") Integer count,
                                            @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(Parser.getSortOrders(sortBy));
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return teacherService.findAll(pageRequest).stream()
                .map(teacherMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a teacher by id")
    public TeacherResponseDto update(@PathVariable(value = "id") Long id,
                                     @RequestBody @Valid TeacherRequestDto dto) {
        Teacher teacher = teacherMapper.mapToModel(dto);
        teacher.setId(id);
        return teacherMapper.mapToDto(teacherService.save(teacher));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a teacher by id")
    public void delete(@PathVariable(value = "id") Long id) {
        teacherService.delete(id);
    }

    @DeleteMapping("/{teacherId}/students/{studentId}")
    @ApiOperation(value = "Remove the student (by id) from the teacher list")
    public void deleteTeacher(@PathVariable(value = "teacherId") Long teacherId,
                              @PathVariable(value = "studentId") Long studentId) {
        teacherService.removeStudent(teacherId, studentId);
    }
}
