package ua.opnu.practice1_template.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.opnu.practice1_template.model.OnlineCourse;
import ua.opnu.practice1_template.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<OnlineCourse> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<OnlineCourse> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public OnlineCourse createCourse(OnlineCourse course) {
        return courseRepository.save(course);
    }

    public OnlineCourse updateCourse(Long id, OnlineCourse courseDetails) {
        OnlineCourse course = courseRepository.findById(id).orElseThrow();
        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        course.setCategory(courseDetails.getCategory());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<OnlineCourse> getCoursesByCategory(String category) {
        return courseRepository.findByCategory(category);
    }

}



