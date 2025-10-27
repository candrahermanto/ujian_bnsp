package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.dto.BukuDto;
import com.jobhun.ujian_bnsp.dto.BukuSearchDto;
import com.jobhun.ujian_bnsp.model.Buku;
import com.jobhun.ujian_bnsp.services.BukuService;
import com.jobhun.ujian_bnsp.services.KategoriSevice;
import com.jobhun.ujian_bnsp.services.PenerbitService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/buku")
public class AdminBukuController {

    private final BukuService bukuService;
    private final ModelMapper modelMapper;
    private final PenerbitService penerbitService;
    private final KategoriSevice kategoriSevice;

    public AdminBukuController(BukuService bukuService, ModelMapper modelMapper, PenerbitService penerbitService, KategoriSevice kategoriSevice) {
        this.bukuService = bukuService;
        this.modelMapper = modelMapper;
        this.penerbitService = penerbitService;
        this.kategoriSevice = kategoriSevice;
    }

    @GetMapping
    public String bukuPage(BukuSearchDto bukuSearchDto, Model model, Pageable pageable){
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        model.addAttribute("bukuList", bukuService.getAllBuku(pageable));
        return "admin/buku/list";
    }

    @PostMapping("/search")
    public String search(BukuSearchDto bukuSearchDto, Model model, Pageable pageable){
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        model.addAttribute("bukuList", bukuService.searchBuku(modelMapper.map(bukuSearchDto, Buku.class),pageable));
        return "admin/buku/list";
    }

    @GetMapping("/add")
    public String addBuku(BukuDto bukuDto, Model model, Pageable pageable){
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        return "admin/buku/add";
    }

    @GetMapping("/edit")
    public String editBuku(@RequestParam String idBuku, Model model, Pageable pageable){
        model.addAttribute("bukuDto", modelMapper.map(bukuService.getBukuById(idBuku), BukuDto.class));
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
        return "admin/buku/add";
    }


    @PostMapping("/add")
    public String simpanBuku(@Valid BukuDto bukuDto, BindingResult bindingResult, Model model, Pageable pageable, RedirectAttributes redirectAttributes){
        List<String> statusList = new ArrayList<>();
       if(bindingResult.hasErrors()){
           model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
           model.addAttribute("kategoriList", kategoriSevice.getAllKategori(pageable));
           statusList.add("error");
           statusList.add("Buku gagal ditambahkan");
           model.addAttribute("status", statusList);
           return "admin/buku/add";
       }
        statusList.add("success");
        statusList.add("Buku berhasil ditambahkan");
        redirectAttributes.addFlashAttribute("status", statusList);
       bukuService.simpanBuku(modelMapper.map(bukuDto, Buku.class));
       return "redirect:/admin/buku";

    }

    @GetMapping("/hapus")
    public String confirmasihapus(@RequestParam String idBuku, Model model){
        model.addAttribute("idBuku", idBuku);
        return "admin/buku/hapus_confirm";
    }

    @PostMapping("/hapus")
    public String hapusKategori(@RequestParam String idBuku, Model model, Pageable pageable){
        bukuService.deleteBuku(idBuku);
        model.addAttribute("bukuList", bukuService.getAllBuku(pageable));
        return "redirect:/admin/buku";
    }
}
