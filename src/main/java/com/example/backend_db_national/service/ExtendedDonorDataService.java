package com.example.backend_db_national.service;

import com.example.backend_db_national.dto.ExtendedDonorDataCreateDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataUpdateDTO;

import java.util.Optional;

public interface ExtendedDonorDataService {
    Optional<ExtendedDonorDataDTO> getExtendedDonorData(String cnp);
    Optional<ExtendedDonorDataDTO> createExtendedDonorData(ExtendedDonorDataCreateDTO dto);
    Optional<ExtendedDonorDataDTO> updateOrCreateExtendedDonorData(String cnp, ExtendedDonorDataUpdateDTO dto);
    Optional<ExtendedDonorDataDTO> deleteExtendedDonorData(String cnp);
}
