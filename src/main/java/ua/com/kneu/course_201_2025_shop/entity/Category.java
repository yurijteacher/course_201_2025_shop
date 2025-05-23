package ua.com.kneu.course_201_2025_shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "categories")
public class Category {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI NN
    private Long id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


}
