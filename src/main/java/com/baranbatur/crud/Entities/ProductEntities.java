package com.baranbatur.crud.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String type;
    @Column
    String name;
    @Column
    int price;
    @Column
    int stock;
    @Column
    String description;
}
