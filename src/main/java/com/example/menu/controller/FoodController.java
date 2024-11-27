package com.example.menu.controller;

import com.example.menu.food.Food;
import com.example.menu.food.FoodRepository;
import com.example.menu.food.FoodRequestDTO;
import com.example.menu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    // Méthode POST pour créer un nouvel élément
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Indique que la ressource a été créée
    public FoodResponseDTO saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);  // Convertit le DTO en entité
        Food savedFood = repository.save(foodData);  // Sauvegarde l'entité dans la base de données
        return new FoodResponseDTO(savedFood);  // Retourne l'objet créé dans le format DTO
    }

    // Méthode GET pour récupérer la liste de tous les aliments
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(FoodResponseDTO::new)  // Conversion de Food à FoodResponseDTO
                .collect(Collectors.toList());
    }
}
