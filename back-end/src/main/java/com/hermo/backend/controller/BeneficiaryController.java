package com.hermo.backend.controller;

import com.hermo.backend.entities.Beneficiary;
import com.hermo.backend.service.BeneficiaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BeneficiaryController {
    Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

    private BeneficiaryService service;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.service = beneficiaryService;
    }

    @GetMapping("/beneficiaries")
    public List<Beneficiary> getAllBeneficiaries(@RequestParam @Nullable String beneficiaryName, @RequestParam @Nullable String beneficiaryId) {
        logger.info("Request received for get all beneficiaries.");
        return service.getAllBeneficiaries(beneficiaryName, beneficiaryId);
    }
}
