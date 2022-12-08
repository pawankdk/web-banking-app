/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.service;

import com.mycompany.CoreBank.entity.Account;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Atish Ojha
 */
public interface AccountService {
    public Account createNewAccount(Account a);
    public ArrayList<Account> listAllAccounts();
    public Optional<Account> findByAccNo(int accNo);
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount);
    public Account deposit(int accNo, float amount);
    public Account withdraw(int accNo, float amount);
    public int deleteAccount(int accNo);
    public ArrayList<Account> findByName(String name);
    //this is to find account
    public Optional<Account> editAccount(int accNo);
    //this is to update account
    public Account eitAccount(Account a);
}
