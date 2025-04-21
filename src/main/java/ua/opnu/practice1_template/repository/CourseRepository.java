package ua.opnu.practice1_template.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.opnu.practice1_template.model.OnlineCourse;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<OnlineCourse, Long> {
    List<OnlineCourse> findByCategory(String category);


}




