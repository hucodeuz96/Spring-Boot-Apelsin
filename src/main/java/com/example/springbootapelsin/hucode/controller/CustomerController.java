package com.example.springbootapelsin.hucode.controller;

import com.example.springbootapelsin.hucode.entity.Customer;
import com.example.springbootapelsin.hucode.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author "Husniddin Ulachov"
 * @created 2:40 PM on 6/12/2022
 * @project spring-boot-Apelsin
 */
@RequestMapping("customer")
@RequiredArgsConstructor
@Controller
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String getAll(Model model) {
        customerService.getAll(model);
        return "customer/list";// page nomi list.html templates ni ichida
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "customer/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Customer customer, Model model) {
        customerService.add(model, customer);
        return "customer/list";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Customer customer =  customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customer/update";
    }
    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id,Model model) {
        customerService.deleteById(id);
        customerService.getAll(model);
        return "customer/list";

    }

}
