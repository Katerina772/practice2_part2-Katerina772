package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Enrollment;
import ua.opnu.practice1_template.model.OnlineCourse;
import ua.opnu.practice1_template.model.Student;
import ua.opnu.practice1_template.repository.CourseRepository;
import ua.opnu.practice1_template.repository.EnrollmentRepository;
import ua.opnu.practice1_template.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment enrollStudentToCourse(Long studentId, Long courseId) {
        if (enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new RuntimeException("Student is already enrolled in this course");
        }

        Student student = studentRepository.findById(studentId).orElseThrow();
        OnlineCourse course = courseRepository.findById(courseId).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(LocalDate.now());

        return enrollmentRepository.save(enrollment);
    }

    public void unenrollStudentFromCourse(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}

