package com.example.springbootapelsin.hucode.service;

import com.example.springbootapelsin.hucode.dto.ProductDto;
import com.example.springbootapelsin.hucode.entity.Category;
import com.example.springbootapelsin.hucode.entity.Product;
import com.example.springbootapelsin.hucode.repository.CategoryRepository;
import com.example.springbootapelsin.hucode.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public void getAll(Model model) {
        List<Product> all = productRepository.findAll();
        model.addAttribute("list",all);
    }
    public void add(Model model, ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).get();
        Product product = Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .photo(productDto.getPhoto())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .category(category)
                .build();
        productRepository.save(product);
        model.addAttribute("list",productRepository.findAll());
    }
    public ProductDto  getById(int id){
        Product product = productRepository.findById(id).orElseThrow();
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .photo(product.getPhoto())
                .categoryId(product.getCategory().getId())
                .build();
    }
    public void deleteById(int id){
        productRepository.deleteById(id);
    }




}
