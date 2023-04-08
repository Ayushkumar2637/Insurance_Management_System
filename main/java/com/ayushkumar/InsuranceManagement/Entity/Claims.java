package com.ayushkumar.InsuranceManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Claims {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true,nullable = false)
    private int claim_number;
    @Column(length = 50,nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate claim_date;
    @Column(nullable = false)
    private String claim_status;

    @ManyToOne
    @JoinColumn(name="insurance_policy_id")
    private Insurance_policies insurance_policies;

    public Insurance_policies getInsurance_policies() {
        return insurance_policies;
    }
    public void setInsurance_policies(Insurance_policies insurance_policies) {
        this.insurance_policies = insurance_policies;
    }

    public Claims() {
    }
    public Claims(int id,int claim_number,String description,LocalDate claim_date,String claim_status) {
        this.id = id;
        this.claim_number=claim_number;
        this.description=description;
        this.claim_date=claim_date;
        this.claim_status=claim_status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getClaim_number() {
        return claim_number;
    }
    public void setClaim_number(int claim_number) {
        this.claim_number = claim_number;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaim_date() {
        return claim_date;
    }
    public void setClaim_date(LocalDate claim_date) {
        this.claim_date = claim_date;
    }

    public String getClaim_status() {
        return claim_status;
    }
    public void setClaim_status(String claim_status) {
        this.claim_status = claim_status;
    }

    @Override
    public String toString() {
        return "Claims{" +
                "id=" + id +
                ", claim_number=" + claim_number +
                ", description='" + description + '\'' +
                ", claim_date=" + claim_date +
                ", claim_status='" + claim_status + '\'' +
                '}';
    }
}
