package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
