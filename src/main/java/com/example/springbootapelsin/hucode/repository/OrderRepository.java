package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface OrderRepository extends JpaRepository<Order,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
