package com.jobhun.ujian_bnsp.controller;

import com.jobhun.ujian_bnsp.dto.PenerbitDto;
import com.jobhun.ujian_bnsp.dto.PenerbitSearchDto;
import com.jobhun.ujian_bnsp.model.Penerbit;
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
@RequestMapping("/admin/penerbit")
public class AdminPenerbitController {

    private final PenerbitService penerbitService;
    private final ModelMapper modelMapper;


    public AdminPenerbitController(PenerbitService penerbitService, ModelMapper modelMapper) {
        this.penerbitService = penerbitService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String penerbitPage(PenerbitSearchDto penerbitSearchDto,Model model, Pageable pageable) {
        model.addAttribute("penerbitList", penerbitService.getAllPenerbit(pageable));
        return "admin/penerbit/list";
    }


    @PostMapping("/search")
    public String searchPenerbit(PenerbitSearchDto penerbitSearchDto, Model model, Pageable pageable) {
        model.addAttribute("penerbitList", penerbitService.searchPenerbit(modelMapper.map(penerbitSearchDto, Penerbit.class), pageable));
        return "admin/penerbit/list";
    }


    @GetMapping("/add")
    public String addPenerbitPage(PenerbitDto penerbitDto, Model model){
        return "admin/penerbit/add";
    }

    @GetMapping("/edit")
    public String editPenerbitPage(@RequestParam String idPenerbit, Model model){
        model.addAttribute("penerbitDto", modelMapper.map(penerbitService.getPenerbitById(idPenerbit), PenerbitDto.class));
        return "admin/penerbit/add";
    }

    @PostMapping("/add")
    public String savePenerbit(@Valid PenerbitDto penerbitDto, BindingResult bindingResult, Model model, Pageable pageable, RedirectAttributes redirectAttributes){
        List<String> statusList = new ArrayList<>();
        if(bindingResult.hasErrors()){
            statusList.add("error");
            statusList.add("Penerbit gagal ditambahkan");
            model.addAttribute("status", statusList);
            return "admin/penerbit/add";
        }
        statusList.add("success");
        statusList.add("Penerbit bergasil ditambahkan");
        redirectAttributes.addFlashAttribute("status", statusList);
        penerbitService.savePenerbit(modelMapper.map(penerbitDto, Penerbit.class));
        return "redirect:/admin/penerbit";
    }

    @GetMapping("/hapus")
    public String hapusConfirmPenerbit(String idPenerbit, Model model){
        model.addAttribute("idPenerbit", idPenerbit);
        return "admin/penerbit/hapus_confirm";
    }

    @PostMapping("/hapus")
    public String hapusPenerbit(String idPenerbit){
        penerbitService.deletePenerbit(idPenerbit);
        return "redirect:/admin/penerbit";
    }
}

