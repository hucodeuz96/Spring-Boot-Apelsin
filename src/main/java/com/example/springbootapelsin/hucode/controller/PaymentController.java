package com.example.springbootapelsin.hucode.controller;

import com.example.springbootapelsin.hucode.dto.PaymentDto;
import com.example.springbootapelsin.hucode.dto.ProductDto;
import com.example.springbootapelsin.hucode.entity.Payment;
import com.example.springbootapelsin.hucode.service.OrderService;
import com.example.springbootapelsin.hucode.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author "Husniddin Ulachov"
 * @created 4:46 PM on 6/14/2022
 * @project spring-boot-Apelsin
 */
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final OrderService orderService;

    @GetMapping
    public String getAll(Model model) {
        paymentService.getAll(model);
        return "payment/list";
    }
    @GetMapping("/add")
    public String getAddPage(Model model) {
        paymentService.add(model);
        return "payment/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String save(@ModelAttribute PaymentDto paymentDto, Model model) {
        paymentService.save(model,paymentDto);
        return "redirect:";
    }
    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id, Model model) {
        paymentService.deleteById(id,model);
        paymentService.getAll(model);
        return "payment/list";
    }




}
