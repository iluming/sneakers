package com.lhc.sneakers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.SneakersService;
import com.lhc.sneakers.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Sneakers")
public class SneakersController {
    @Autowired
    SneakersService sneakersService;

    /**
     *
     * @param pageNo   要显示第几页内容
     * @param pageSize    一页显示多少条
     * @return
     */
    @GetMapping("/listSneakers")
    public Map listSneakers(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                            @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        Map map = new HashMap();
       PageInfo<Sneakers> sneakersPageInfo = sneakersService.listSneakers(pageNo,pageSize);
       map.put("sneakersPageInfo",sneakersPageInfo);
        map.put("listSneakers",sneakersPageInfo.getList());
        return map;
    }

    @GetMapping("/getSneakers")
    public Map getSneakers(int sneakersId){
        Map map = new HashMap();
        Sneakers sneakers = sneakersService.getSneaker(sneakersId);
        map.put("sneakers",sneakers);
        return map;
    }
}
