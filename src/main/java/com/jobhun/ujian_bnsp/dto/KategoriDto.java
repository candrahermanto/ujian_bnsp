package com.jobhun.ujian_bnsp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KategoriDto {
    private Long idKategori;
    @NotEmpty(message = "Nama tidak boleh kosong")
    private String namaKategori;
    @NotEmpty(message = "deskripsi tidak boleh kosong")
    private String deskripsi;
}
