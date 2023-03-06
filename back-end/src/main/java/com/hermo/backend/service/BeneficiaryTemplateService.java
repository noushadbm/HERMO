package com.hermo.backend.service;

import com.hermo.backend.entities.BeneficiaryFieldTemplate;
import com.hermo.backend.repository.BeneficiaryTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryTemplateService {
    private BeneficiaryTemplateRepository repository;

    @Autowired
    public BeneficiaryTemplateService(BeneficiaryTemplateRepository beneficiaryTemplateRepository) {
        this.repository = beneficiaryTemplateRepository;
    }

    public List<BeneficiaryFieldTemplate> getAllFieldTemplates() {
        Sort sortDescending = Sort.by("templateId").descending();
        return this.repository.findAll(sortDescending);
    }

    public BeneficiaryFieldTemplate createFieldTemplate(BeneficiaryFieldTemplate fieldTemplate) {
        return this.repository.save(fieldTemplate);
    }
}
