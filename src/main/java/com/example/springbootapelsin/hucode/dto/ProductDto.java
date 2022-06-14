package com.example.springbootapelsin.hucode.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Integer categoryId ;
    private String description;
    private BigDecimal price;
    private String photo;
}
