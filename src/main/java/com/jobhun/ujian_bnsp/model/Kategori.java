package com.jobhun.ujian_bnsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKategori;
    private String namaKategori;
    private String deskripsi;
    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Buku> bukuSet = new HashSet<>();
}
