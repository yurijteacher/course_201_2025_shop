package ua.com.kneu.course_201_2025_shop.controller;


import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.kneu.course_201_2025_shop.entity.Customer;
import ua.com.kneu.course_201_2025_shop.entity.Roles;
import ua.com.kneu.course_201_2025_shop.entity.Users;
import ua.com.kneu.course_201_2025_shop.repository.CustomerRepository;
import ua.com.kneu.course_201_2025_shop.repository.UserRepository;

import java.util.Collections;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public UserController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }


    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model){

        model.addAttribute("users", new Users());
        model.addAttribute("customer", new Customer());

        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUser(@Valid Users users,
                              BindingResult bindingResult1,
                              @Valid Customer customer,
                              BindingResult bindingResult2){

        // Validation

        if(bindingResult1.hasErrors()){
             return "registration";
        }

        if(bindingResult2.hasErrors()){
            return "registration";
        }

        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        Users users1 = userRepository.save(users);

        users1.setRoleset(Collections.singleton(new Roles(1L, "ROLE_USER")));

        customer.setUser(users1);

        customerRepository.save(customer);

        return "redirect:/login";
    }

}
