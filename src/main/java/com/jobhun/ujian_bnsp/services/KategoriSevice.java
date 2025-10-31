package com.jobhun.ujian_bnsp.services;

import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.repository.KategoriRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return kategoriRepository.findById(idKategori).orElseThrow(() -> new EntityNotFoundException("kategori tidak ditemukan: " + idKategori));
    }

    public void saveKategori(Kategori kategori){
        kategoriRepository.save(kategori);
    }

    public void deleteKategori(Long idKategori){
       Kategori kategori = kategoriRepository.findById(idKategori). orElseThrow(() -> new EntityNotFoundException("kategori tidak ditemukan: " + idKategori));
       if(kategori.getBukuSet().isEmpty()) {
           kategoriRepository.deleteById(idKategori);
       } else {
           throw new RuntimeException("Gagal hapus kategori, masih ada buku yang menggunakan kategori tersebut");
       }
    }
}

