package com.hermo.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="beneficiary_extended")
@Getter
@Setter
public class BeneficiaryExtended {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeId;

    private String attributeName;

    private String attributeValue;

    @ManyToOne
    @JoinColumn(name = "fk_template_id", nullable = false)
    private BeneficiaryFieldTemplate fieldTemplate;
}
