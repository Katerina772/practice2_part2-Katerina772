package ua.opnu.practice1_template.controller;

import ua.opnu.practice1_template.model.OnlineCourse;
import ua.opnu.practice1_template.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<OnlineCourse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlineCourse> getCourseById(@PathVariable Long id) {
        Optional<OnlineCourse> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OnlineCourse createCourse(@RequestBody OnlineCourse course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineCourse> updateCourse(@PathVariable Long id, @RequestBody OnlineCourse courseDetails) {
        try {
            OnlineCourse updatedCourse = courseService.updateCourse(id, courseDetails);
            return ResponseEntity.ok(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<OnlineCourse> getCoursesByCategory(@PathVariable String category) {
        return courseService.getCoursesByCategory(category);
    }


}


