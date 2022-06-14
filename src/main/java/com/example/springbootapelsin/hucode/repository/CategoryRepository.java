package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
