package com.baranbatur.crud.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private int id;
    private String name;
    private String type;
    private String description;
}
