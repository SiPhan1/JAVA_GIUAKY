package com.example.PhanTienSi_GiuaKy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3)
    private String maNV;

    @Column(nullable = false, length = 100)
    private String tenNV;

    @Column(nullable = false, length = 3)
    private String phai;

    @Column(nullable = false, length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "maPhong", nullable = false)
    private PhongBan phongBan;

    @Column(nullable = false)
    private int luong;

}

