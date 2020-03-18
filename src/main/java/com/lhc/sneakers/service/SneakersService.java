package com.lhc.sneakers.service;

import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.entity.Sneakers;

import java.util.List;

public interface SneakersService {
    PageInfo<Sneakers> listSneakers(int pageNo, int pageSize);

    Sneakers getSneaker(int sneakerId);

    void addSneakers(Sneakers sneakers);

    void upDateSneakers(Sneakers sneakers);

    void  deleteSneakers(int sneakersId);
}
