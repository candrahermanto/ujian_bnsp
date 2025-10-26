package com.jobhun.ujian_bnsp.repository;

import com.jobhun.ujian_bnsp.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
}
