/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.service;

import com.mycompany.CoreBank.entity.Account;
import com.mycompany.CoreBank.respository.AccountRepository;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atish Ojha
 */
@Service
public class AccountServiceJPAImplementation implements AccountService
{
    @Autowired
    AccountRepository ar;

    @Override
    public Account deposit(int accNo, float amount) {
        Optional<Account> accResponse = findByAccNo(accNo);
        if(accResponse.isPresent())
        {
            Account a = accResponse.get();
            System.out.print(a);
            a.setAmount(a.getAmount() + amount);
            return ar.save(a);
        }
        return null;
    }

    @Override
    public Account withdraw(int accNo, float amount) {
        Optional<Account> accResponse = findByAccNo(accNo);
        if(accResponse.isPresent())
        {
            Account a = accResponse.get();
            System.out.print(a);
            if(a.getAmount() < amount)
            {
                return null;
            }
            else
            {
                a.setAmount(a.getAmount() - amount);
                return ar.save(a);
            }
        }
        return null;
    }

    @Override
    public Account createNewAccount(Account a) {
        Account acc;
        try
        {
            Optional<Account> accResponse = ar.findById(a.getAccNo());
            if(accResponse.isPresent())
            {
                return null;
            }
            else
            {
                return ar.save(a);
            }
        }
        catch(NoSuchElementException ex)
        {
            System.out.println(ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<Account> listAllAccounts() {
        return (ArrayList<Account>)ar.findAll();
    }

    @Override
    public Optional<Account> findByAccNo(int accNo) {
        return ar.findById(accNo);
    }

    @Override
    public int deleteAccount(int accNo) {
        Optional<Account> accResponse = findByAccNo(accNo);
        if(accResponse.isPresent())
        {
            Account a;
            try
            {
                a = accResponse.get();
            }
            catch(NoSuchElementException e)
            {
                a = null;
            }
            if(a != null)
            {
                if(a.getAmount() == 0)
                {
                    ar.delete(a);
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public ArrayList<Account> findByName(String name) {
        return ar.findAllByName(name);
    }

    @Override
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount){
        Optional<Account> srcAccResponse = findByAccNo(srcAccNo);
        if(srcAccResponse.isPresent())
        {
            Account srcAcc = srcAccResponse.get();
            if(srcAcc.getAmount() >= amount)
            {
                Optional<Account> trgtAccResponse = findByAccNo(trgtAccNo);
                if(trgtAccResponse.isPresent())
                {
                    Account trgtAcc = trgtAccResponse.get();
                    srcAcc.setAmount(srcAcc.getAmount()-amount);
                    trgtAcc.setAmount(trgtAcc.getAmount()+amount);
                    ar.save(srcAcc);
                    ar.save(trgtAcc);
                    return 0;
                    //transfered
                }
                else
                {
                    //target account not present
                    return -1;
                }
            }
            else
            {
                //balance is less in source
                return 2;
            }
        }
        else
        {
            //no source account
            return 1;
        }
    }

    @Override
    public Optional<Account> editAccount(int accNo) {
        return ar.findById(accNo);
    }
    
    @Override
    public Account eitAccount(Account a) {
        Account acc;
        try
        {
            Optional<Account> accResponse = ar.findById(a.getAccNo());
            if(accResponse.isPresent())
            {
                return ar.save(a);
            }
            else
            {
                return null;
            }
        }
        catch(NoSuchElementException ex)
        {
            System.out.println(ex);
        }
        
        return null;
    }
    
}
