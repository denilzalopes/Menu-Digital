package com.example.menu.food;

public class FoodResponseDTO {

    private String title;
    private String image;
    private String price;

    // Constructeur qui prend un objet Food
    public FoodResponseDTO(Food food) {
        this.title = food.getTitle();
        this.image = food.getImage();
        this.price = food.getPrice().toString();  // On convertit BigDecimal en String
    }

    // Getters et Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
