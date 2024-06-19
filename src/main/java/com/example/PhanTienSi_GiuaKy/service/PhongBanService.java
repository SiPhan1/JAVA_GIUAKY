package com.example.PhanTienSi_GiuaKy.service;

import com.example.PhanTienSi_GiuaKy.entity.PhongBan;
import com.example.PhanTienSi_GiuaKy.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {

    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }
}
