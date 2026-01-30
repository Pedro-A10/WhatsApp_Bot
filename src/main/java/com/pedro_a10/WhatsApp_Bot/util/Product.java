package com.pedro_a10.WhatsApp_Bot.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String nameProduct;
    private String priceProduct;
    private int quantityProduct;
    private String imagePath;

    public Product(String nameProduct, String priceProduct, int quantityProduct, String imagePath) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.imagePath = imagePath;
    }
}
