package com.example.backend_db_national.mapper;

import com.example.backend_db_national.dto.ExtendedDonorDataCreateDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataUpdateDTO;
import com.example.backend_db_national.entity.ExtendedDonorData;
import org.springframework.stereotype.Component;

@Component
public class ExtendedDonorDataMapper {
    public ExtendedDonorDataDTO toDTO(ExtendedDonorData extendedDonorData){
        ExtendedDonorDataDTO dto = new ExtendedDonorDataDTO();
        dto.soonestDonationDate = extendedDonorData.soonestDonationDate;
        dto.bloodType = extendedDonorData.bloodType;
        dto.riskFactors = extendedDonorData.riskFactors;
        return dto;
    }

    public ExtendedDonorData toExtendedDonorData(ExtendedDonorDataCreateDTO dto){
        ExtendedDonorData extendedDonorData = new ExtendedDonorData();
        extendedDonorData.cnp = dto.cnp;
        extendedDonorData.soonestDonationDate = dto.soonestDonationDate;
        extendedDonorData.bloodType = dto.bloodType;
        extendedDonorData.riskFactors = dto.riskFactors;
        return extendedDonorData;
    }

    public ExtendedDonorData toExtendedDonorData(String cnp, ExtendedDonorDataUpdateDTO dto){
        ExtendedDonorData extendedDonorData = new ExtendedDonorData();
        extendedDonorData.cnp = cnp;
        extendedDonorData.soonestDonationDate = dto.soonestDonationDate;
        extendedDonorData.bloodType = dto.bloodType;
        extendedDonorData.riskFactors = dto.riskFactors;
        return extendedDonorData;
    }
}
