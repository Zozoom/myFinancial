package com.myFinance.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table( name="benefitItem" )
public @Data class BenefitItem {

    @Id
    @Column(name = "ID", unique=true, nullable=false)
    private Long id;

    @Column(name = "szepCard1", nullable=false, length = 8)
    private String szepCard1;

    @Column(name = "szepCard2", nullable=false, length = 8)
    private String szepCard2;

    @Column(name = "erzsiCard", nullable=false, length = 8)
    private String erzsiCard;

    @Column(name = "modificationDate", nullable=false)
    private String modificationDate;

}
