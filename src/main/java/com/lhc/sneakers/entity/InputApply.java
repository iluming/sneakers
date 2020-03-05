package com.lhc.sneakers.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class InputApply {

    private int inputId;
    private int sneakersId;
    private String color;
    private int size;
    private int num;
    private String numUnit;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date applyTime;

    private BigDecimal price;
    private BigDecimal totalPrice;
    private double netWeight;
    private String invoiceNumber; //发票号码
    private int applicantId;
    private int supplierId;
    private String position;


}
