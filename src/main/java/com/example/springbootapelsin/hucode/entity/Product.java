package com.example.springbootapelsin.hucode.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@ToString
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String name;

    @ManyToOne
    private Category category;

    @Column(length = 20)
    private String description;

    @Column(precision = 6,scale = 2)
    private BigDecimal price;

    @Column(length = 1024)
    private String photo;
}
