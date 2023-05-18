package com.example.backend_db_national.repository;

import com.example.backend_db_national.entity.ExtendedDonorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendedDonorDataRepository extends JpaRepository<ExtendedDonorData, String> {
}
