package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.dto.BukuSearchDto;
import com.jobhun.ujian_bnsp.model.Buku;
import com.jobhun.ujian_bnsp.services.BukuService;
import com.jobhun.ujian_bnsp.services.KategoriSevice;
import com.jobhun.ujian_bnsp.services.PenerbitService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BerandaController {

    private final BukuService bukuService;
    private final ModelMapper modelMapper;
    private final PenerbitService penerbitService;
    private final KategoriSevice kategoriSevice;

    public BerandaController(BukuService bukuService, ModelMapper modelMapper, PenerbitService penerbitService, KategoriSevice kategoriSevice) {
        this.bukuService = bukuService;
        this.modelMapper = modelMapper;
        this.penerbitService = penerbitService;
        this.kategoriSevice = kategoriSevice;
    }



    @GetMapping
    public String page(BukuSearchDto bukuSearchDto,Model model, Pageable pageable){
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        model.addAttribute("bukuList", bukuService.getAllBuku(pageable));
        return "beranda";
    }

    @PostMapping("/search")
    public String search(BukuSearchDto bukuSearchDto, Model model, Pageable pageable){
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        model.addAttribute("bukuList", bukuService.searchBuku(modelMapper.map(bukuSearchDto, Buku.class),pageable));
        return "beranda";
    }
}
