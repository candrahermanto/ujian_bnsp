package com.jobhun.ujian_bnsp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PenerbitSearchDto {

    private String idPenerbit;
    private String nama;
    private String kota;
    private String telepon;
}
