package com.example.backend_db_national.controller;

import com.example.backend_db_national.dto.ExtendedDonorDataCreateDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataDTO;
import com.example.backend_db_national.dto.ExtendedDonorDataUpdateDTO;
import com.example.backend_db_national.service.ExtendedDonorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class ExtendedDonorDataController {
    private final ExtendedDonorDataService extendedDonorDataService;

    public ExtendedDonorDataController(ExtendedDonorDataService extendedDonorDataService){
        this.extendedDonorDataService = extendedDonorDataService;
    }

    @GetMapping("/donors/extended/{cnp}")
    ResponseEntity<ExtendedDonorDataDTO> getExtendedDonorData(@PathVariable String cnp){
        Optional<ExtendedDonorDataDTO> extendedDonorDataDTOOptional = extendedDonorDataService.getExtendedDonorData(cnp);
        return extendedDonorDataDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping("/donors/extended")
    ResponseEntity<ExtendedDonorDataDTO> createExtendedDonorData(@RequestBody ExtendedDonorDataCreateDTO dto){
        Optional<ExtendedDonorDataDTO> extendedDonorDataDTOOptional = extendedDonorDataService.createExtendedDonorData(dto);
        return extendedDonorDataDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/donors/extended/{cnp}")
    ResponseEntity<ExtendedDonorDataDTO> updateOrCreateExtendedDonorData(@PathVariable String cnp, @RequestBody ExtendedDonorDataUpdateDTO dto){
        Optional<ExtendedDonorDataDTO> extendedDonorDataDTOOptional = extendedDonorDataService.updateOrCreateExtendedDonorData(cnp, dto);
        return extendedDonorDataDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @DeleteMapping("/donors/extended/{cnp}")
    ResponseEntity<ExtendedDonorDataDTO> deleteExtendedDonorData(@PathVariable String cnp){
        Optional<ExtendedDonorDataDTO> extendedDonorDataDTOOptional = extendedDonorDataService.deleteExtendedDonorData(cnp);
        return extendedDonorDataDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
