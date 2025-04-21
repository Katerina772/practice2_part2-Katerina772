package ua.opnu.practice1_template.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
@Data
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(name = "module_order")
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private OnlineCourse course;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progresses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    public OnlineCourse getCourse() {
        return course;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setCourse(OnlineCourse course) {
        this.course = course;
    }
}

