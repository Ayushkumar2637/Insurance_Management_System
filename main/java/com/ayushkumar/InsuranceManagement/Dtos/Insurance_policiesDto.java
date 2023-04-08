package com.ayushkumar.InsuranceManagement.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

public class Insurance_policiesDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("policy_number")
    private int policy_number;
    @JsonProperty("policy_type")
    private String policy_type;
    @JsonProperty("coverage_amount")
    private int coverage_amount;
    @JsonProperty("premium")
    private int premium;
    @JsonProperty("start_date")
    private LocalDate start_date;
    @JsonProperty("end_date")
    private LocalDate end_date;

    @JsonProperty("clients_id")
    private int clients_id;
    @JsonProperty("claims_id")
    private List<Integer> claims_id;

    public Insurance_policiesDto() {
    }
    public Insurance_policiesDto(int id,int policy_number,String policy_type,int coverage_amount,int premium,LocalDate start_date,LocalDate end_date) {
        this.id = id;
        this.policy_number=policy_number;
        this.policy_type=policy_type;
        this.coverage_amount=coverage_amount;
        this.premium=premium;
        this.start_date=start_date;
        this.end_date=end_date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPolicy_number() {
        return policy_number;
    }
    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }

    public String getPolicy_type() {
        return policy_type;
    }
    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public int getCoverage_amount() {
        return coverage_amount;
    }
    public void setCoverage_amount(int coverage_amount) {
        this.coverage_amount = coverage_amount;
    }

    public int getPremium() {
        return premium;
    }
    public void setPremium(int premium) {
        this.premium = premium;
    }

    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public int getClients_id() {
        return clients_id;
    }
    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }

    public List<Integer> getClaims_id() {
        return claims_id;
    }
    public void setClaims_id(List<Integer> claims_id) {
        this.claims_id = claims_id;
    }

    @Override
    public String toString() {
        return "Insurance_policiesDto{" +
                "id=" + id +
                ", policy_number=" + policy_number +
                ", policy_type='" + policy_type + '\'' +
                ", coverage_amount=" + coverage_amount +
                ", premium=" + premium +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", clients_id=" + clients_id +
                ", claims_id=" + claims_id +
                '}';
    }
}
