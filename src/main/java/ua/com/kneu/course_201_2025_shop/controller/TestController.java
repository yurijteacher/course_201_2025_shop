package ua.com.kneu.course_201_2025_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.course_201_2025_shop.entity.Category;
import ua.com.kneu.course_201_2025_shop.service.CategoryService;

@Controller
public class TestController {

    private final CategoryService categoryService;

    public TestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute("message", "Hello World!");

        model.addAttribute("categories", categoryService.findAll());

        return "home";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String image) {

        Category category = new Category();

        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.save(category);

        return "redirect:/";
    }

    @PostMapping("/updateCategory")
    public String updateCategoryById(
            @RequestParam(name = "id") Category category,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image) {

        // validation

        category.setName(name);
        category.setDescription(description);
        category.setImage(image);
        categoryService.save(category);

        return "redirect:/";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategoryById(
            @RequestParam(name = "id") Long id) {
        if(id != null) {
            categoryService.deleteById(id);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/delivery")
    public String getDeliveryPage() {
        return "delivery";
    }

    @GetMapping("/payment")
    public String getPaymentPage() {
        return "payment";
    }


    @GetMapping("/user")
    public String getUserPage() {
        return "user_page";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin_page";
    }

}
