package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.dto.KategoriDto;
import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.services.KategoriSevice;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/kategori")
public class AdminKategoriController {

    private final KategoriSevice kategoriSevice;
    private final ModelMapper modelMapper;

    public AdminKategoriController(KategoriSevice kategoriSevice, ModelMapper modelMapper) {
        this.kategoriSevice = kategoriSevice;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String kategoriPage(Model model, Pageable pageable){
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        return "admin/kategori/list";
    }

    @GetMapping("/add")
    public String addKategoriPage(KategoriDto kategoriDto, Model model){
        return "admin/kategori/add";
    }

    @GetMapping("/edit")
    public String editKategoriPage(@RequestParam Long idKategori, Model model){
        KategoriDto kategoriDto = modelMapper.map(kategoriSevice.getKategoriById(idKategori), KategoriDto.class);
        model.addAttribute("kategoriDto", kategoriDto);
        return "admin/kategori/add";
    }

    @PostMapping("/add")
    public String saveKategoriPage(@Valid KategoriDto kategoriDto,
                                   BindingResult bindingResult,
                                   Model model,
                                   Pageable pageable,
                                   HttpServletResponse response){
       if(bindingResult.hasErrors()){
           return "admin/kategori/add";
       } else {
           kategoriSevice.saveKategori(modelMapper.map(kategoriDto, Kategori.class));
           model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
           return "redirect:/admin/kategori";
       }
    }

    @GetMapping("/hapus")
    public String confirmasihapus(@RequestParam Long idKategori, Model model){
        model.addAttribute("idKategori", idKategori);
        return "admin/kategori/hapus_confirm";
    }

    @PostMapping("/hapus")
    public String hapusKategori(@RequestParam Long idKategori, Model model, Pageable pageable){
        kategoriSevice.deleteKategori(idKategori);
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        return "redirect:/admin/kategori";
    }
}
