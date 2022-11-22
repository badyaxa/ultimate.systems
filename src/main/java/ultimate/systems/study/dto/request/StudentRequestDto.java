package ultimate.systems.study.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import ultimate.systems.study.util.ValidEmail;

@Data
public class StudentRequestDto {
    @NotNull(message = "First name can not be null")
    @Size(min = 3, max = 30, message = "First name length must be between 3 and 30")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(min = 3, max = 30, message = "Last name length must be between 3 and 30")
    private String lastName;

    @ValidEmail
    private String email;

    @NotNull(message = "Direction can not be null")
    @Size(min = 3, max = 30, message = "Direction length must be between 3 and 30")
    private String direction;
}
