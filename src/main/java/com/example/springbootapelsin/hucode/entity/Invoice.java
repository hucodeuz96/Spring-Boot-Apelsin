package com.example.springbootapelsin.hucode.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id //Fk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//serial
    private Integer id;

    @OneToOne // boglanish
    @JoinColumn(name = "ord_id")//shu nom bilan
    private Order order;


    @Column(nullable = false,precision = 8,scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    @CreatedDate // sistemadan oladi
    private Date issued;

    @Column(nullable = false)
    private Date due;

}
