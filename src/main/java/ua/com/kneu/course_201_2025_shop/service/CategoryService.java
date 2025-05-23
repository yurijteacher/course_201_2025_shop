package ua.com.kneu.course_201_2025_shop.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.course_201_2025_shop.entity.Category;
import ua.com.kneu.course_201_2025_shop.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);  // Insert ... Update WHERE id=?
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

}
