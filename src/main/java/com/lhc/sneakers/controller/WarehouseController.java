package com.lhc.sneakers.controller;

import com.lhc.sneakers.entity.Warehouse;
import com.lhc.sneakers.service.WarehouseService;
import com.lhc.sneakers.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/warehouses")
    public Object spareWarehouse(@RequestParam(value = "sneakersId") int sneakersId){
        List<Warehouse> warehouseList = warehouseService.list(sneakersId);
        return ResultUtil.success(warehouseList);
    }
}
