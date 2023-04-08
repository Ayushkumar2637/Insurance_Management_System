package com.ayushkumar.InsuranceManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Insurance_policies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true,nullable = false)
    private int policy_number;
    @Column(nullable = false)
    private String policy_type;
    @Column(nullable = false)
    private int coverage_amount;
    @Column(nullable = false)
    private int premium;
    @Column(nullable = false)
    private LocalDate start_date;
    @Column(nullable = false)
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Clients clients;
    @OneToMany(mappedBy = "insurance_policies")
    private List<Claims> claims;

    public List<Claims> getClaims() {
        return claims;
    }
    public void setClaims(List<Claims> claims) {
        this.claims = claims;
    }

    public Clients getClients() {
        return clients;
    }
    public void setClients(Clients clients) {
        this.clients = clients;
    }



    public Insurance_policies() {
    }
    public Insurance_policies(int id,int policy_number,String policy_type,int coverage_amount,int premium,LocalDate start_date,LocalDate end_date) {
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

    @Override
    public String toString() {
        return "Insurance_policies{" +
                "id=" + id +
                ", policy_number=" + policy_number +
                ", policy_type='" + policy_type + '\'' +
                ", coverage_amount=" + coverage_amount +
                ", premium=" + premium +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
