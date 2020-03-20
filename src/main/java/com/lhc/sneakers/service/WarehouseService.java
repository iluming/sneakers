package com.lhc.sneakers.service;

import com.lhc.sneakers.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> list(int sneakersId);

}
