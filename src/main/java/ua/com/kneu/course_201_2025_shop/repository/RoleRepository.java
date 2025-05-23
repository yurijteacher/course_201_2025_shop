package ua.com.kneu.course_201_2025_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_201_2025_shop.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
