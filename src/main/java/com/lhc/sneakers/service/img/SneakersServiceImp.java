package com.lhc.sneakers.service.img;

import com.lhc.sneakers.dao.SneakersMapper;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.SneakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SneakersServiceImp implements SneakersService {
    @Autowired
    SneakersMapper sneakersMapper;

    @Override
    public Sneakers getSneaker(int sneakerId) {

        return sneakersMapper.getSneakers(sneakerId);
    }
}
