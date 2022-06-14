package com.example.springbootapelsin.hucode.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {
    @Id //--> FK
    @GeneratedValue(strategy = GenerationType.IDENTITY)// -->serial
    private Integer id;

    @Column(nullable = false, length = 250)
    private String name;

    @OneToMany(mappedBy = "category")// table ochma deyishlik uchun
    private List<Product> productList;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(Integer id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }

    public Category(Category cat) {
        this.getName();
    }
}
