package com.lhc.sneakers.controller;

import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.SneakersService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Sneakers")
public class SneakersController {
    @Autowired
    SneakersService sneakersService;

    @GetMapping("/getSneakers")
    public Map getSneakers(int sneakersId){
        Map map = new HashMap();
        Sneakers sneakers = sneakersService.getSneaker(sneakersId);
        map.put("sneakers",sneakers);
        return map;
    }
}
