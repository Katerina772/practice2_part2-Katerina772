package ua.opnu.practice1_template.model;



import jakarta.persistence.*;
import lombok.Data;
import ua.opnu.practice1_template.part2.User;

import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
//// додано
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
////

    public void setUser(User user) {
        this.user = user;
    }
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;

    // Геттери
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

