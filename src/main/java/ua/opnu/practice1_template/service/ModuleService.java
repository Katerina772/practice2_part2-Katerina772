package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Module;
import ua.opnu.practice1_template.model.OnlineCourse;
import ua.opnu.practice1_template.repository.CourseRepository;
import ua.opnu.practice1_template.repository.ModuleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<ua.opnu.practice1_template.model.Module> getModulesByCourseId(Long courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    public ua.opnu.practice1_template.model.Module createModule(Long courseId, ua.opnu.practice1_template.model.Module module) {
        OnlineCourse course = courseRepository.findById(courseId).orElseThrow();
        module.setCourse(course);
        return moduleRepository.save(module);
    }

    public Optional<ua.opnu.practice1_template.model.Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public ua.opnu.practice1_template.model.Module updateModule(Long id, ua.opnu.practice1_template.model.Module moduleDetails) {
        Module module = moduleRepository.findById(id).orElseThrow();
        module.setTitle(moduleDetails.getTitle());
        module.setOrder(moduleDetails.getOrder());
        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}

