package ultimate.systems.study.dto.response;

import lombok.Data;

@Data
public class TeacherResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String subject;
}
