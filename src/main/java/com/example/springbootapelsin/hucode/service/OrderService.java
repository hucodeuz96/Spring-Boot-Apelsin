package com.example.springbootapelsin.hucode.service;

import com.example.springbootapelsin.hucode.dto.OrderDto;
import com.example.springbootapelsin.hucode.entity.Customer;
import com.example.springbootapelsin.hucode.entity.Detail;
import com.example.springbootapelsin.hucode.entity.Invoice;
import com.example.springbootapelsin.hucode.entity.Order;
import com.example.springbootapelsin.hucode.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 10:48 AM on 6/12/2022
 * @project spring-boot-Apelsin
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    private  final InvoiceRepository invoiceRepository;

    private final  DetailRepository detailRepository;

    public void getAll(Model model){
        model.addAttribute("list",orderRepository.findAll());

    }
    public void getOne(Model model){
        model.addAttribute("customerList",customerRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
    }
    public void save(Model model, OrderDto orderDto){
//        System.out.println(orderDto);
        Order order = new Order();
        order.setCustomer(customerRepository.getById(orderDto.getCustomerId()));
        order.setDate(new Date());
        Order saveOrder = orderRepository.save(order);

        Detail detail = new Detail();
        detail.setOrder(saveOrder);
        detail.setProduct(productRepository.getById(orderDto.getProductId()));
        detail.setQuntity(orderDto.getQuantity());
        Detail saveDetail = detailRepository.save(detail);



        BigDecimal price = saveDetail.getProduct().getPrice();
        short quntity = saveDetail.getQuntity();
       Date date = new Date();
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       calendar.add(Calendar.DATE,3);
       Date date3 = new Date();
       date3=calendar.getTime();
        Invoice invoice = Invoice.builder()
                .order(saveOrder)
                .amount(price.multiply(BigDecimal.valueOf(quntity)))
                .issued(date)
                .due(date3)
                .build();
        invoiceRepository.save(invoice);

//        model.addAttribute("list",orderRepository.findAll());
    }

    public void deleteById(int id){
        int detailId = 0;
        for (Detail detail : detailRepository.findAll()) {
            if (detail.getOrder().getId()==id) {
                detailId=detail.getId();
            }
        }
        int invoiceId = 0;
        for (Invoice invoice : invoiceRepository.findAll()) {
            if (invoice.getOrder().getId()==id) {
                invoiceId=invoice.getId();
            }
        }
        detailRepository.deleteById(detailId);
        invoiceRepository.deleteById(invoiceId);
        orderRepository.deleteById(id);
    }
}
