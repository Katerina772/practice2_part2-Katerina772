package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    private Boolean completed = false;

    // Геттери
    public Long getId() {
        return id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public Module getModule() {
        return module;
    }

    public Boolean getCompleted() {
        return completed;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}



