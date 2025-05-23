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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users user;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
