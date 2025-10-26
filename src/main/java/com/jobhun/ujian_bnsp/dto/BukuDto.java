package com.jobhun.ujian_bnsp.dto;

import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.model.Penerbit;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BukuDto {

    @NotEmpty(message = "ID Buku tidak boleh kosong")
    private String idBuku;
    @NotNull(message = "Kategori tidak boleh kosong")
    private Kategori kategori;
    @NotEmpty(message = "Nama Buku tidak boleh kosong")
    private String namaBuku;
    @NotNull(message = "Harga tidak boleh kosong")
    private BigDecimal harga;
    @NotNull(message = "Stok tidak boleh kosong")
    private Integer stok;
    @NotNull(message = "Penerbit tidak boleh kosong")
    private Penerbit penerbit;

}
