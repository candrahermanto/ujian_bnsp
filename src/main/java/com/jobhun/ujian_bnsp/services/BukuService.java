package com.jobhun.ujian_bnsp.services;

import com.jobhun.ujian_bnsp.model.Buku;
import com.jobhun.ujian_bnsp.repository.BukuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;

    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public Page<Buku> getAllBuku(Pageable pageable){
        return bukuRepository.findAll(pageable);
    }

    public void simpanBuku(Buku buku) {
        bukuRepository.save(buku);
    }

    public Buku getBukuById(String idBuku) {
        return bukuRepository.findById(idBuku).orElse(null);
    }

    public void deleteBuku(String idBuku) {
        bukuRepository.deleteById(idBuku);
    }

    public Page<Buku> searchBuku(Buku buku, Pageable pageable) {

        if(!buku.getIdBuku().isEmpty()) {
            return bukuRepository.findByIdBuku(buku.getIdBuku(), pageable);
        }

        if(!buku.getNamaBuku().isEmpty()) {
            return  bukuRepository.findByNamaBukuLike("%"+buku.getNamaBuku()+"%", pageable);
        }
        if(Objects.nonNull(buku.getPenerbit())) {
            return bukuRepository.findByPenerbit(buku.getPenerbit(), pageable);
        }
        if(Objects.nonNull(buku.getKategori())) {
            return bukuRepository.findByKategori(buku.getKategori(), pageable);
        }

        return Page.empty();

    }

    public Page<Buku> getMinStock(Pageable pageable) {
        List<Buku> list = new ArrayList<>();
        list.add(bukuRepository.findFirstByOrderByStok());
        Page<Buku> result = new PageImpl<>(list, pageable, 1);
        return result;
    }
}
