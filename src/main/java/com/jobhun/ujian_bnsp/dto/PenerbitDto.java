package com.jobhun.ujian_bnsp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PenerbitDto {

    @NotEmpty(message = "ID Penerbit tidak boleh kosong")
    private String idPenerbit;
    @NotEmpty(message = "Nama tidak boleh kosong")
    private String nama;
    @NotEmpty(message = "Alamat tidak boleh kosong")
    private String alamat;
    @NotEmpty(message = "Kota tidak boleh kosong")
    private String kota;
    @Size(min = 13, max = 15, message = "Telepon harus 10-13 digit")
    private String telepon;
}
