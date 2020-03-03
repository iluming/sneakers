package com.lhc.sneakers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class Sneakers {
    private int sneakersId;
    private int speciesId;
    private int brandId;
    private String sneakersName;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private int sneakersListedTime;
    private int sneakersSex;
    private BigDecimal sneakersPrice;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateTime;
    private int sneakersInventory;

}
