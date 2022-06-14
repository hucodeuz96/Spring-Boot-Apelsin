package com.example.springbootapelsin.hucode.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="orders")
public class Order {
    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    @OneToMany(mappedBy = "order")
    private List<Detail> detail;

}
