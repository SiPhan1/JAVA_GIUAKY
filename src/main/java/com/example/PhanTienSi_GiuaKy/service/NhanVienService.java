package com.example.PhanTienSi_GiuaKy.service;

import com.example.PhanTienSi_GiuaKy.entity.NhanVien;
import com.example.PhanTienSi_GiuaKy.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Page<NhanVien> getNhanVienPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }

    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public NhanVien addNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(Long id) {
        nhanVienRepository.deleteById(id);
    }
}
