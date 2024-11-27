package com.example.menu.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement un ID unique
    private long id;

    private String title;
    private String image;
    private BigDecimal price;  // Utilisation de BigDecimal pour le prix

    // Constructeur qui prend un FoodRequestDTO
    public Food(FoodRequestDTO data) {
        this.title = data.title();
        this.image = data.image();
        this.price = new BigDecimal(data.price());  // Conversion de String en BigDecimal
    }
}
