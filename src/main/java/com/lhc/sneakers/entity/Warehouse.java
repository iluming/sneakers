package com.lhc.sneakers.entity;

import lombok.Data;

@Data
public class Warehouse {
    private int warehouseId;
    private int sneakersId;
    private String color;
    private float size;
    private int inventory;

}
