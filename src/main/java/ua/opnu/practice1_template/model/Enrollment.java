package ua.opnu.practice1_template.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "enrollments")
@Data

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private OnlineCourse course;

    private LocalDate enrolledAt = LocalDate.now();

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progresses;

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public OnlineCourse getCourse() {
        return course;
    }

    public LocalDate getEnrolledAt() {
        return enrolledAt;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(OnlineCourse course) {
        this.course = course;
    }

    public void setEnrolledAt(LocalDate enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
