package com.sy.soyeon.service;

import com.sy.soyeon.mapper.HamhamMapper;
import com.sy.soyeon.vo.HamhamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HamhamImpl implements Hamham{

    //서비스impl에서 맵퍼 연결
    @Autowired
    private HamhamMapper hamMapper;

    @Override
    public List<HamhamVO> listData() {
        return hamMapper.listData();
    }

    @Override
    public HamhamVO oneData(HamhamVO hamhamVO) {
        return hamMapper.oneData(hamhamVO);
    }

    @Override
    public int insertData(HamhamVO hamhamVO) {
        return hamMapper.insertData(hamhamVO);
    }

    @Override
    public int updateData(HamhamVO hamhamVO) {
        return hamMapper.updateData(hamhamVO);
    }

    @Override
    public int deleteData(HamhamVO hamhamVO) {
        return hamMapper.deleteData(hamhamVO);
    }
}
