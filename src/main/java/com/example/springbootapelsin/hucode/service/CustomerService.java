package com.example.springbootapelsin.hucode.service;

import com.example.springbootapelsin.hucode.entity.Customer;
import com.example.springbootapelsin.hucode.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author "Husniddin Ulachov"
 * @created 2:40 PM on 6/12/2022
 * @project spring-boot-Apelsin
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void getAll(Model model) {
        model.addAttribute("list", customerRepository.findAll());
    }
    public void add(Model model, Customer customer) {
        customerRepository.save(customer);
        model.addAttribute("list", customerRepository.findAll());
    }
    public Customer  getById(int id){
        return customerRepository.findById(id).orElseThrow();
    }
    public void deleteById(int id){
        customerRepository.deleteById(id);
    }
}
