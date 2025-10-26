package com.jobhun.ujian_bnsp.services;

import com.jobhun.ujian_bnsp.model.Penerbit;
import com.jobhun.ujian_bnsp.repository.PenerbitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class PenerbitService {

    private final PenerbitRepository penerbitRepository;

    public PenerbitService(PenerbitRepository penerbitRepository) {
        this.penerbitRepository = penerbitRepository;
    }

    public Page<Penerbit> getAllPenerbit(Pageable pageable){
        return penerbitRepository.findAll(pageable);
    }

    public void savePenerbit(Penerbit penerbit) {
        penerbitRepository.save(penerbit);
    }

    public Penerbit getPenerbitById(String idPenerbit) {
        return penerbitRepository.findById(idPenerbit).orElse(null);
    }

    public void deletePenerbit(String idPenerbit) {
        penerbitRepository.deleteById(idPenerbit);
    }

    public Page<Penerbit> searchPenerbit(Penerbit penerbit, Pageable pageable) {
        if(Objects.nonNull(penerbit.getIdPenerbit())) {
            return penerbitRepository.findByIdPenerbit(penerbit.getIdPenerbit(), pageable);
        }
        return Page.empty();

    }
}
