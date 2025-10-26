package com.jobhun.ujian_bnsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class Buku {
    @Id
    private String idBuku;
    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private Kategori kategori;
    private String namaBuku;
    private BigDecimal harga;
    private Integer stok;
    @ManyToOne
    @JoinColumn(name = "id_penerbit")
    private Penerbit penerbit;
}
