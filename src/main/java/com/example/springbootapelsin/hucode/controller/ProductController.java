package com.example.springbootapelsin.hucode.controller;


import com.example.springbootapelsin.hucode.dto.ProductDto;
import com.example.springbootapelsin.hucode.repository.CategoryRepository;
import com.example.springbootapelsin.hucode.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private  final CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model) {
        productService.getAll(model);
        return "product/list";// page nomi list.html templates ni ichida
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "product/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute ProductDto productDto, Model model) {
        productService.add(model, productDto);
        return "product/list";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        ProductDto product =  productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "product/update";
    }
    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id,Model model) {
        productService.deleteById(id);
        productService.getAll(model);
        return "product/list";
    }










}

