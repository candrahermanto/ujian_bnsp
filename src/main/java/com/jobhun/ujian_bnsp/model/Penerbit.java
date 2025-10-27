package com.jobhun.ujian_bnsp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Penerbit {
    @Id
    private String idPenerbit;
    @NotNull(message = "Nama tidak boleh kosong")
    private String nama;
    @NotNull(message = "Alamat tidak boleh kosong")
    private String alamat;
    @NotNull(message = "Kota tidak boleh kosong")
    private String kota;
    @Size(min = 13, max = 15, message = "Telepon harus 10-13 digit")
    private String telepon;
    @OneToMany(mappedBy = "penerbit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Buku> bukuSet = new HashSet<>();

}
