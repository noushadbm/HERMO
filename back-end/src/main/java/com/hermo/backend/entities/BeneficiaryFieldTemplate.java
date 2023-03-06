package com.hermo.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="beneficiary_field_template")
public class BeneficiaryFieldTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "template_id")
    private Long templateId;

    @Column(unique = true, nullable = false)
    private String templateName;

    @NotNull
    private String attributeType;

    private String valueRange;

    private boolean isNullable;

    // Value to fill in case of nullable field changes to non-nullable
    private String nullFillValue;

    // Name to be displayed for column/field in UI.
    private String displayName;

    @JsonIgnore
    @OneToMany(mappedBy = "fieldTemplate", fetch = FetchType.LAZY)
    private List<BeneficiaryExtended> beneficiaryExtendedFields;
}
