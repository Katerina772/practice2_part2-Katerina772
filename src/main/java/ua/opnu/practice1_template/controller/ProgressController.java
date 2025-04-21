package ua.opnu.practice1_template.controller;

import ua.opnu.practice1_template.model.Progress;
import ua.opnu.practice1_template.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @GetMapping("/enrollment/{enrollmentId}")
    public List<Progress> getProgressByEnrollmentId(@PathVariable Long enrollmentId) {
        return progressService.getProgressByEnrollmentId(enrollmentId);
    }

    @PostMapping
    public Progress updateModuleProgress(
            @RequestParam Long enrollmentId,
            @RequestParam Long moduleId,
            @RequestParam Boolean completed) {
        return progressService.updateModuleProgress(enrollmentId, moduleId, completed);
    }

    @GetMapping("/percentage/{enrollmentId}")
    public double getCourseProgressPercentage(@PathVariable Long enrollmentId) {
        return progressService.getCourseProgressPercentage(enrollmentId);
    }
}

