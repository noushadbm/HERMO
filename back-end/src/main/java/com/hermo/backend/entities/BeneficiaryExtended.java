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

    private String attributeType;

    private String valueRange;

    private boolean isNullable;

    private String attributeValue;

    // Value to fill in case of nullable field changes to non-nullable
    private String nullFillValue;
}
