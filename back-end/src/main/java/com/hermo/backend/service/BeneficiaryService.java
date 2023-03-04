package com.hermo.backend.service;

import com.hermo.backend.entities.Beneficiary;
import com.hermo.backend.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    private BeneficiaryRepository repository;

    @Autowired
    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.repository = beneficiaryRepository;
    }
    public List<Beneficiary> getAllBeneficiaries(String beneficiaryName, String beneficiaryId) {
        Sort sortDescending = Sort.by("id").descending();
        return repository.findAll(sortDescending);
    }
}
