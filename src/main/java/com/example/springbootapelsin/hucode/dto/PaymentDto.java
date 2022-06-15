package com.example.springbootapelsin.hucode.dto;

import lombok.*;

import java.util.Date;

/**
 * @author "Husniddin Ulachov"
 * @created 4:53 PM on 6/14/2022
 * @project spring-boot-Apelsin
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    int id;
    int invoiceId;
    Double Amount;
}
