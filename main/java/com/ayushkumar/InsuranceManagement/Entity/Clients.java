package com.ayushkumar.InsuranceManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="full_name",length = 30,nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date_of_birth;
    @Column(nullable = false)
    private String address;
    @Column(name="Gmail_Id",unique = true,nullable = false)
    private String contact_info;

    @OneToMany(mappedBy = "clients")
    private List<Insurance_policies> insurance_policies;

    public List<Insurance_policies> getInsurance_policies() {
        return insurance_policies;
    }
    public void setInsurance_policies(List<Insurance_policies> insurance_policies) {
        this.insurance_policies = insurance_policies;
    }

    public Clients() {
    }
    public Clients(int id,String name,LocalDate date_of_birth,String address,String contact_info) {
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

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                ", contact_info='" + contact_info + '\'' +
                '}';
    }
}
