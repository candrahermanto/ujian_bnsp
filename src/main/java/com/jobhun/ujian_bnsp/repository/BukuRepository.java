package com.jobhun.ujian_bnsp.repository;

import com.jobhun.ujian_bnsp.model.Buku;
import com.jobhun.ujian_bnsp.model.Kategori;
import com.jobhun.ujian_bnsp.model.Penerbit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, String> {
    Page<Buku> findByIdBuku(String idBuku, Pageable pageable);

    Page<Buku>  findByPenerbit(Penerbit penerbit, Pageable pageable);

    Page<Buku> findByKategori(Kategori kategori, Pageable pageable);

    Page<Buku> findByNamaBukuLike(String namaBuku, Pageable pageable);

    Buku findFirstByOrderByStok();
}
