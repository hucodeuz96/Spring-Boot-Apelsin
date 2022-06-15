package com.example.springbootapelsin.hucode.controller;

import com.example.springbootapelsin.hucode.dto.OrderDto;
import com.example.springbootapelsin.hucode.repository.OrderRepository;
import com.example.springbootapelsin.hucode.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author "Husniddin Ulachov"
 * @created 10:46 AM on 6/12/2022
 * @project spring-boot-Apelsin
 */
@RequestMapping("/order")
@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository repository;

    @GetMapping()
    public String getAll(Model model) {
        orderService.getAll(model);
        return "order/list";
    }
    @GetMapping("/add")
    public String getAddPage(Model model) {
        orderService.getOne(model);
        return "order/add"; //page nomi -> list.html templates
    }
    @PostMapping("/add")
    public String savePage(Model model, OrderDto order){
        orderService.save(model,order);
        model.addAttribute("list",repository.findAll());
        return "redirect:";
    }
    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id, Model model) {
        orderService.deleteById(id);
        orderService.getAll(model);
        return "order/list";
    }



}
