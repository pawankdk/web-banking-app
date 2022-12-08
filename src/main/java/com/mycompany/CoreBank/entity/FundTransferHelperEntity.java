/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.entity;

/**
 *
 * @author Atish Ojha
 */
public class FundTransferHelperEntity {
    private int srcAccNo;
    private int trgtAccNo;
    private float amount;

    public FundTransferHelperEntity() {
    }

    public FundTransferHelperEntity(int srcAccNo, int trgtAccNo, float amount) {
        this.srcAccNo = srcAccNo;
        this.trgtAccNo = trgtAccNo;
        this.amount = amount;
    }

    public int getSrcAccNo() {
        return srcAccNo;
    }

    public void setSrcAccNo(int srcAccNo) {
        this.srcAccNo = srcAccNo;
    }

    public int getTrgtAccNo() {
        return trgtAccNo;
    }

    public void setTrgtAccNo(int trgtAccNo) {
        this.trgtAccNo = trgtAccNo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
}
