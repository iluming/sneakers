package com.lhc.sneakers.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.dao.SneakersMapper;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.SneakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakersServiceImp implements SneakersService {
    @Autowired
    SneakersMapper sneakersMapper;

    @Override
    public PageInfo<Sneakers> listSneakers(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Sneakers> sneakersList = sneakersMapper.listSneakers();
        //用PageInfo对结果进行包装
        PageInfo<Sneakers> page = new PageInfo<Sneakers>(sneakersList);
        return page;
    }

    @Override
    public List<Sneakers> listSneakers() {
        return sneakersMapper.listSneakers();
    }

    @Override
    public Sneakers getSneaker(int sneakerId) {
        return sneakersMapper.getSneakers(sneakerId);
    }

    @Override
    public void addSneakers(Sneakers sneakers) {
        sneakersMapper.addSneakers(sneakers);
    }

    @Override
    public void upDateSneakers(Sneakers sneakers) {
        sneakersMapper.upDateSneakers(sneakers);
    }

    @Override
    public void deleteSneakers(int sneakersId) {
        sneakersMapper.deleteSneakers(sneakersId);
    }
}
