package com.olamireDev.credoCodeChallenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@RequiredArgsConstructor
@Data
public class Account {
    @Id
    private String phoneNumber;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String bvn;
    private BigDecimal wallet = BigDecimal.ZERO;

    public Account(String phoneNumber, String firstname, String lastname, String bvn) {
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bvn = bvn;
    }
}
