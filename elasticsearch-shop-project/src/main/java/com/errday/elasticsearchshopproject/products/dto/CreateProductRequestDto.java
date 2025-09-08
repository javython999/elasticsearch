package com.errday.elasticsearchshopproject.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProductRequestDto {

    private String name;
    private String description;
    private int price;
    private double rating;
    private String category;

}
