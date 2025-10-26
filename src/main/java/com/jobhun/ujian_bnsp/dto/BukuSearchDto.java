package com.jobhun.ujian_bnsp.dto;

import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.model.Penerbit;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BukuSearchDto {
    private String idBuku;
    private Kategori kategori;
    private String namaBuku;
    private BigDecimal harga;
    private Integer stok;
    private Penerbit penerbit;
}
