package com.example.backend_db_national.service.impl;

import com.example.backend_db_national.dto.ExtendedDonorDataCreateDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataUpdateDTO;
import com.example.backend_db_national.entity.ExtendedDonorData;
import com.example.backend_db_national.mapper.ExtendedDonorDataMapper;
import com.example.backend_db_national.repository.ExtendedDonorDataRepository;
import com.example.backend_db_national.service.ExtendedDonorDataService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExtendedDonorDataServiceImpl implements ExtendedDonorDataService {
    private final ExtendedDonorDataRepository extendedDonorDataRepository;
    private final ExtendedDonorDataMapper extendedDonorDataMapper;
    public ExtendedDonorDataServiceImpl(ExtendedDonorDataRepository extendedDonorDataRepository, ExtendedDonorDataMapper extendedDonorDataMapper){
        this.extendedDonorDataRepository = extendedDonorDataRepository;
        this.extendedDonorDataMapper = extendedDonorDataMapper;
    }

    @Override
    public Optional<ExtendedDonorDataDTO> getExtendedDonorData(String cnp) {
        Optional<ExtendedDonorData> extendedDonorDataOptional = extendedDonorDataRepository.findById(cnp);
        return extendedDonorDataOptional.map(extendedDonorDataMapper::toDTO);
    }

    @Override
    public Optional<ExtendedDonorDataDTO> createExtendedDonorData(ExtendedDonorDataCreateDTO dto) {
        if(extendedDonorDataRepository.existsById(dto.cnp)){
            return Optional.empty();
        }
        else{
            ExtendedDonorData extendedDonorData = extendedDonorDataRepository.save(extendedDonorDataMapper.toExtendedDonorData(dto));
            return Optional.of(extendedDonorDataMapper.toDTO(extendedDonorData));
        }
    }

    @Override
    public Optional<ExtendedDonorDataDTO> updateOrCreateExtendedDonorData(String cnp, ExtendedDonorDataUpdateDTO dto) {
        ExtendedDonorData extendedDonorData = extendedDonorDataRepository.save( extendedDonorDataMapper.toExtendedDonorData(cnp, dto));
        return Optional.of(extendedDonorDataMapper.toDTO(extendedDonorData));
    }

    @Override
    public Optional<ExtendedDonorDataDTO> deleteExtendedDonorData(String cnp) {
        Optional<ExtendedDonorData> donorOptional = extendedDonorDataRepository.findById(cnp);
        if (donorOptional.isPresent()) {
            ExtendedDonorData donor = donorOptional.get();
            extendedDonorDataRepository.delete(donor);
            return Optional.of(extendedDonorDataMapper.toDTO(donor));
        }
        return Optional.empty();
    }
}
