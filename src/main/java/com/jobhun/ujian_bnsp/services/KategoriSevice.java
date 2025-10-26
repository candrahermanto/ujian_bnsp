package com.jobhun.ujian_bnsp.services;

import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.repository.KategoriRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KategoriSevice {

    private final KategoriRepository kategoriRepository;

    public KategoriSevice(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public Page<Kategori> getAllKategori(Pageable pageable){
        return kategoriRepository.findAll(pageable);
    }

    public Kategori getKategoriById(Long idKategori){
        return kategoriRepository.findById(idKategori).orElse(null);
    }

    public Kategori saveKategori(Kategori kategori){
        return kategoriRepository.save(kategori);
    }

    public void deleteKategori(Long idKategori){
        kategoriRepository.deleteById(idKategori);
    }
}

