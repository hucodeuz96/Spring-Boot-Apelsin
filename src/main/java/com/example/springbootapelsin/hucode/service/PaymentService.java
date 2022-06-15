package com.example.springbootapelsin.hucode.service;

import com.example.springbootapelsin.hucode.dto.PaymentDto;
import com.example.springbootapelsin.hucode.entity.Invoice;
import com.example.springbootapelsin.hucode.entity.Order;
import com.example.springbootapelsin.hucode.entity.Payment;
import com.example.springbootapelsin.hucode.repository.InvoiceRepository;
import com.example.springbootapelsin.hucode.repository.OrderRepository;
import com.example.springbootapelsin.hucode.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentService {
   private  final  PaymentRepository paymentRepository;
   private final  OrderRepository orderRepository;
   private final  InvoiceRepository invoiceRepository;

    public void getAll(Model model){
        model.addAttribute("list",paymentRepository.findAll());
    }
    public void add(Model model) {
        List<Integer> invoiceId = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            invoiceId.add(order.getInvoice().getId());
        }
        model.addAttribute("invoiceList" ,invoiceId);
    }
    public void  save(Model model, PaymentDto paymentDto){
        Invoice invoice = invoiceRepository.findById(paymentDto.getInvoiceId()).orElseThrow();
        Payment payment = Payment.builder()
                .amount(BigDecimal.valueOf(paymentDto.getAmount()))
                .invoice(invoice)
                .build();
        paymentRepository.save(payment);
        model.addAttribute("list",paymentRepository.findAll());
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") int id, Model model) {
        paymentRepository.deleteById(id);
        return "payment/list";
    }




}
