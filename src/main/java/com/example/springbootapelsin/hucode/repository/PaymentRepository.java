package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
