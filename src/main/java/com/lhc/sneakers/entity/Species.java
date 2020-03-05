package com.lhc.sneakers.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Species {
    private int speciesId;
    private String speciesName;
    private Date speciesCreateTime;

}
