package ua.opnu.practice1_template.controller;

import ua.opnu.practice1_template.model.Module;
import ua.opnu.practice1_template.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses/{courseId}/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public List<Module> getModulesByCourseId(@PathVariable Long courseId) {
        return moduleService.getModulesByCourseId(courseId);
    }

    @PostMapping
    public Module createModule(@PathVariable Long courseId, @RequestBody Module module) {
        return moduleService.createModule(courseId, module);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Optional<Module> module = moduleService.getModuleById(id);
        return module.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module moduleDetails) {
        try {
            Module updatedModule = moduleService.updateModule(id, moduleDetails);
            return ResponseEntity.ok(updatedModule);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}



