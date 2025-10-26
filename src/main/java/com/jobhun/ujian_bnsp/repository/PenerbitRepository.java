package com.jobhun.ujian_bnsp.repository;

import com.jobhun.ujian_bnsp.model.Penerbit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenerbitRepository extends JpaRepository<Penerbit, String> {
    Page<Penerbit> findByIdPenerbit(String idPenerbit, Pageable pageable);
}
