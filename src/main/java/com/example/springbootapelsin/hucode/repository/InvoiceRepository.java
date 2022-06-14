package com.example.springbootapelsin.hucode.repository;

import com.example.springbootapelsin.hucode.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
