/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Atish
 */

//This is model class or entity
@Entity
public class Account implements Serializable {
    @Id
    private int accNo;
    private String name;
    private String address;
    private float amount;
    private char accType;

    public Account() {
    }

    public Account(int accNo, String name, String address, float amount, char accType) {
        this.accNo = accNo;
        this.name = name;
        this.address = address;
        this.amount = amount;
        this.accType = accType;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public char getAccType() {
        return accType;
    }

    public void setAccType(char accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        return "Account{" + "accNo=" + accNo + ", name=" + name + ", address=" + address + ", amount=" + amount + ", accType=" + accType + '}';
    }
    
       
}
