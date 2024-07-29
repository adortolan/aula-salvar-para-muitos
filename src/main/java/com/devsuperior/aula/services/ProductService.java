package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        for(CategoryDTO catDto : dto.getCategories()) {
            //Desta forma aparece o nome que foi inserido da categoria
            Category category = categoryRepository.getReferenceById(catDto.getId());
            //Category category = new Category();
            //category.setId(catDto.getId());
           //category.setName(catDto.getName());
            product.getCategories().add(category);
        }

        product = repository.save(product);
        return new ProductDTO(product);
    }
}
