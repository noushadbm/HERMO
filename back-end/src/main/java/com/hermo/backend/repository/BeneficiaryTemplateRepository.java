package com.hermo.backend.repository;

import com.hermo.backend.entities.BeneficiaryFieldTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryTemplateRepository extends JpaRepository<BeneficiaryFieldTemplate, Long> {
}
