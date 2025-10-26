package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.services.BukuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @RequestMapping("/detail")
    public String detailPage(@RequestParam String idBuku, Model model){
        model.addAttribute("buku", bukuService.getBukuById(idBuku));
        return "buku/detail";
    }
}
