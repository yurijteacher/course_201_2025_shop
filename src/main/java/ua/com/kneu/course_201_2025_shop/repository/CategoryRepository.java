package ua.com.kneu.course_201_2025_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.kneu.course_201_2025_shop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
