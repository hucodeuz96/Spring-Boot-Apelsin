package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface DetailRepository extends JpaRepository<Detail,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
