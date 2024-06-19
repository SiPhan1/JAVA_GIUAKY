package com.example.PhanTienSi_GiuaKy.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String maPhong;

    @Column(nullable = false, length = 30)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<NhanVien> nhanvien;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Set<NhanVien> getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Set<NhanVien> nhanvien) {
        this.nhanvien = nhanvien;
    }
}
