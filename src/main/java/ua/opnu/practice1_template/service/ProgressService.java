package ua.opnu.practice1_template.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Enrollment;
import ua.opnu.practice1_template.model.Module;
import ua.opnu.practice1_template.model.Progress;
import ua.opnu.practice1_template.repository.EnrollmentRepository;
import ua.opnu.practice1_template.repository.ModuleRepository;
import ua.opnu.practice1_template.repository.ProgressRepository;

import java.util.List;

@Service
public class ProgressService {
    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Progress> getProgressByEnrollmentId(Long enrollmentId) {
        return progressRepository.findByEnrollmentId(enrollmentId);
    }

    public Progress updateModuleProgress(Long enrollmentId, Long moduleId, Boolean completed) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow();
        Module module = moduleRepository.findById(moduleId).orElseThrow();

        Progress progress = progressRepository.findByEnrollmentIdAndModuleId(enrollmentId, moduleId)
                .orElseGet(() -> {
                    Progress newProgress = new Progress();
                    newProgress.setEnrollment(enrollment);
                    newProgress.setModule(module);
                    return newProgress;
                });

        progress.setCompleted(completed);
        return progressRepository.save(progress);
    }

    public double getCourseProgressPercentage(Long enrollmentId) {
        List<Progress> progresses = progressRepository.findByEnrollmentId(enrollmentId);
        if (progresses.isEmpty()) return 0;

        long completed = progresses.stream().filter(Progress::getCompleted).count();
        return (double) completed / progresses.size() * 100;
    }
}

