package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
