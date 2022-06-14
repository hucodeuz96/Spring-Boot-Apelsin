package com.example.springbootapelsin.hucode.service;

import com.example.springbootapelsin.hucode.entity.Category;
import com.example.springbootapelsin.hucode.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public void getAll(Model model) {
        model.addAttribute("list", categoryRepository.findAll());
    }
    public void add(Model model, Category category) {
        categoryRepository.save(category);
        model.addAttribute("list", categoryRepository.findAll());
    }
    public Category  getById(int id){
       return categoryRepository.findById(id).orElseThrow();
    }
    public void deleteById(int id){
        categoryRepository.deleteById(id);
    }





}
