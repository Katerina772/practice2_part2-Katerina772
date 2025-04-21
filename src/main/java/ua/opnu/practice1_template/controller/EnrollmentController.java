package ua.opnu.practice1_template.controller;

import ua.opnu.practice1_template.model.Enrollment;
import ua.opnu.practice1_template.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    @PostMapping
    public Enrollment enrollStudentToCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.enrollStudentToCourse(studentId, courseId);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> unenrollStudentFromCourse(@PathVariable Long enrollmentId) {
        enrollmentService.unenrollStudentFromCourse(enrollmentId);
        return ResponseEntity.noContent().build();
    }
}



