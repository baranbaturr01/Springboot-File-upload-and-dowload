package com.baranbatur.crud.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    String name;
    String type;
    int price;
    int stock;
    String description;
}
