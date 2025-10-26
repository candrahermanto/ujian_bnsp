package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.services.BukuService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/pengadaan")
public class AdminPengadaanController {

    private final BukuService bukuService;

    public AdminPengadaanController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping
    public String pengadaanPage(Model model, Pageable pageable){
        model.addAttribute("bukuList", bukuService.getMinStock(pageable));
        return "admin/pengadaan/list";
    }
}
