package com.hermo.backend.controller;

import com.hermo.backend.entities.BeneficiaryFieldTemplate;
import com.hermo.backend.service.BeneficiaryTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BeneficiaryFieldTemplateController {
    Logger logger = LoggerFactory.getLogger(BeneficiaryFieldTemplateController.class);
    private BeneficiaryTemplateService service;

    @Autowired
    public BeneficiaryFieldTemplateController(BeneficiaryTemplateService beneficiaryTemplateService) {
        this.service = beneficiaryTemplateService;
    }

    @GetMapping("/beneficiaryFieldTemplates")
    public List<BeneficiaryFieldTemplate> getAllFieldTemplates() {
        logger.info("Request received for get all beneficiary field templates.");
        return service.getAllFieldTemplates();
    }

    @PostMapping("/beneficiaryFieldTemplates")
    public BeneficiaryFieldTemplate createFieldTemplates(@Validated @RequestBody BeneficiaryFieldTemplate fieldTemplate) {
        logger.info("Request received for creating beneficiary field templates.");
        return service.createFieldTemplate(fieldTemplate);
    }
}
