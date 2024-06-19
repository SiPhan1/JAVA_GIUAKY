package com.example.PhanTienSi_GiuaKy.controller;

import com.example.PhanTienSi_GiuaKy.entity.NhanVien;
import com.example.PhanTienSi_GiuaKy.entity.PhongBan;
import com.example.PhanTienSi_GiuaKy.service.NhanVienService;
import com.example.PhanTienSi_GiuaKy.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String getAllNhanVien(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<NhanVien> nhanVienPage = nhanVienService.getNhanVienPage(page, 5);
        model.addAttribute("nhanVienPage", nhanVienPage);
        model.addAttribute("currentPage", page);
        return "nhanvien";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongBans", phongBans);
        return "add";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        if (nhanVien == null) {
            return "redirect:/nhanvien";
        }
        model.addAttribute("nhanVien", nhanVien);
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongBans", phongBans);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateNhanVien(@PathVariable Long id, @ModelAttribute NhanVien nhanVien) {
        nhanVien.setId(id);
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
