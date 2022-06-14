package com.example.springbootapelsin.hucode.controller;


import com.example.springbootapelsin.hucode.entity.Category;
import com.example.springbootapelsin.hucode.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    public String getAll(Model model) {
        categoryService.getAll(model);
        return "category/list";// page nomi list.html templates ni ichida
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "category/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Category category, Model model) {
        categoryService.add(model, category);
        return "category/list";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Category category =  categoryService.getById(id);
        model.addAttribute("category", category);
        return "category/update";
    }
    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id,Model model) {
        categoryService.deleteById(id);
        categoryService.getAll(model);
        return "category/list";

    }










}

