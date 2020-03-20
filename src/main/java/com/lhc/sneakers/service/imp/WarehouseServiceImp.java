package com.lhc.sneakers.service.imp;

import com.lhc.sneakers.dao.WarehouseMapper;
import com.lhc.sneakers.entity.Warehouse;
import com.lhc.sneakers.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImp implements WarehouseService {
    @Autowired
    WarehouseMapper warehouseMapper;
    @Override
    public List<Warehouse> list(int sneakersId) {
        List<Warehouse> warehouseList = warehouseMapper.list(sneakersId);

        if (null == warehouseList || 0 == warehouseList.size()){  //说明该球鞋没有入过库，即第一次入库,或者该球鞋的仓库饱满
            List<Warehouse> spareWarehouse = warehouseMapper.spareWH();
            return spareWarehouse;
        }else {
            return warehouseList;
        }
    }
}
