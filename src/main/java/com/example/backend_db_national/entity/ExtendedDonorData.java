package com.example.backend_db_national.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "app_extended_donor_data")
public class ExtendedDonorData {
    @Id
    public String cnp;
    public LocalDate soonestDonationDate;
    public String bloodType, riskFactors;
}
