package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.practice1_template.model.Module;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<ua.opnu.practice1_template.model.Module, Long> {
    List<Module> findByCourseId(Long courseId);
}
