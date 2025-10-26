package com.jobhun.ujian_bnsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKategori;
    private String namaKategori;
    private String deskripsi;
}
