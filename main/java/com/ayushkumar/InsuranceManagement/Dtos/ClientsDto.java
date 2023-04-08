package com.ayushkumar.InsuranceManagement.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class ClientsDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("date_of_birth")
    private LocalDate date_of_birth;
    @JsonProperty("address")
    private String address;
    @JsonProperty("contact_info")
    private String contact_info;

    @JsonProperty("insurance_policies_id")
    private List<Integer> insurance_policies_id;

    public ClientsDto() {
    }
    public ClientsDto(int id,String name,LocalDate date_of_birth,String address,String contact_info) {
        this.id = id;
        this.name=name;
        this.date_of_birth=date_of_birth;
        this.address=address;
        this.contact_info=contact_info;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_info() {
        return contact_info;
    }
    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public List<Integer> getInsurance_policies_id() {
        return insurance_policies_id;
    }
    public void setInsurance_policies_id(List<Integer> insurance_policies_id) {
        this.insurance_policies_id = insurance_policies_id;
    }

    @Override
    public String toString() {
        return "ClientsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                ", contact_info='" + contact_info + '\'' +
                ", insurance_policies_id=" + insurance_policies_id +
                '}';
    }
}
