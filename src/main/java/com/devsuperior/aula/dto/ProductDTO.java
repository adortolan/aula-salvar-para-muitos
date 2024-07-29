package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private final List<CategoryDTO> categories = new ArrayList<>();


    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();

        for (Category category : product.getCategories()) {
            this.categories.add(new CategoryDTO(category));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
