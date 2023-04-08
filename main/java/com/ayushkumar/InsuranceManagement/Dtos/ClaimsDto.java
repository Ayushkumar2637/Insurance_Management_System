package com.ayushkumar.InsuranceManagement.Dtos;

import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ClaimsDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("claim_number")
    private int claim_number;
    @JsonProperty("description")
    private String description;
    @JsonProperty("claim_date")
    private LocalDate claim_date;
    @JsonProperty("claim_status")
    private String claim_status;

    @JsonProperty("insurance_policies_id")
    private int insurance_policies_id;

    public ClaimsDto() {
    }
    public ClaimsDto(int id, int claim_number, String description, LocalDate claim_date, String claim_status) {
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

    public int getInsurance_policies_id() {
        return insurance_policies_id;
    }

    public void setInsurance_policies_id(int insurance_policies_id) {
        this.insurance_policies_id = insurance_policies_id;
    }

    @Override
    public String toString() {
        return "ClaimsDto{" +
                "id=" + id +
                ", claim_number=" + claim_number +
                ", description='" + description + '\'' +
                ", claim_date=" + claim_date +
                ", claim_status='" + claim_status + '\'' +
                ", insurance_policies_id=" + insurance_policies_id +
                '}';
    }
}
