package com.example.springbootapelsin.hucode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Husniddin Ulachov"
 * @created 10:38 AM on 6/12/2022
 * @project spring-boot-Apelsin
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer customerId;
    private Integer productId;
    private Short quantity;
}
