package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.practice1_template.model.Progress;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByEnrollmentId(Long enrollmentId);
    List<Progress> findByModuleId(Long moduleId);

    Optional<Progress> findByEnrollmentIdAndModuleId(Long enrollmentId, Long moduleId); // ← додати це!
}

