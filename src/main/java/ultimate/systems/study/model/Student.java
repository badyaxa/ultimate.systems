package ultimate.systems.study.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String direction;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    @JsonIgnore
    private Set<Teacher> teachers = new HashSet<>();

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.getStudents().add(this);
    }

    public void removeTeacher(long teacherId) {
        Teacher teacher = this.teachers.stream()
                .filter(t -> t.getId() == teacherId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student does not have teacher with Id: "
                        + teacherId));
        this.teachers.remove(teacher);
        teacher.getStudents().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(id, student.id)
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(email, student.email)
                && Objects.equals(direction, student.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, direction);
    }

    @PreRemove
    private void removeTeachersFromStudents() {
        for (Teacher teacher : teachers) {
            teacher.getStudents().remove(this);
        }
        this.teachers.clear();
    }
}
