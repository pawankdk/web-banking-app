/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.controller;

import com.mycompany.CoreBank.entity.Account;
import com.mycompany.CoreBank.entity.FundTransferHelperEntity;
import com.mycompany.CoreBank.service.AccountService;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Atish Ojha
 */
@Controller
public class AccountController {
    
    @Autowired
    AccountService as;
    
    @GetMapping("/createnewaccount")
    public ModelAndView showCreateNewAccountForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("createNewAccountForm");
            mav.addObject("newAccount", new Account());
            return mav;
        }
    }
    @PostMapping("/newAccountProcess")
    public ModelAndView processNewAccount(@ModelAttribute("newAccount")Account account, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(as.createNewAccount(account) == null)
            {
                mav.addObject("message", "Cannot Create New Account, May be Account Number is already taken!!");
            }
            else
            {
                mav.addObject("message", "New Account Creation successful!!");
            }
            return mav;
        }
    }
    
    @GetMapping("/deleteaccount")
    public ModelAndView showDeleteAccountForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("deleteAccountForm");
            mav.addObject("delete", new Account());
            return mav;
        }
    }
    @PostMapping("/deleteAccountProcess")
    public ModelAndView processdeleteAccount(@ModelAttribute("deleteAccount")Account acc, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            int status = as.deleteAccount(acc.getAccNo());
            switch (status)
            {
                case 1:
                       mav.addObject("message", "Account Deleted successful!!");
                       break;
                case -1:
                       mav.addObject("message", "Account have some balance, please withdraw them and than try to close Account!!");
                       break;
                case 0:
                       mav.addObject("message", "Account Cannot be deleted, May be Account doesnot exits!!");   
                       
            }
            return mav;
        }
    }
    
    
    
    @GetMapping("/listallaccounts")
    public ModelAndView showListOfAllAccounts(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ArrayList<Account> accList = as.listAllAccounts();
            ModelAndView mav = new ModelAndView("listallaccountsView");
            mav.addObject("accList", accList);
            return mav;
        }
    }
    
    @GetMapping("/deposit")
    public ModelAndView showDepositForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("depositForm");
            mav.addObject("deposit", new Account());
            return mav;
        }
    }
    @PostMapping("depositProcess")
    public ModelAndView depositProcess(@ModelAttribute ("deposit")Account acc, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(as.deposit(acc.getAccNo(), acc.getAmount()) == null)
            {
                mav.addObject("message", "Cannot Deposit, Something Wrong with account information!!");
            }
            else
            {
                mav.addObject("message", "Deposit Successful!!");
            }
            return mav;
        }
    }
    
    @GetMapping("/withdraw")
    public ModelAndView showWithdrawForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("withdrawForm");
            mav.addObject("withdraw", new Account());
            return mav;
        }
    }
    @PostMapping("withdrawProcess")
    public ModelAndView withdrawProcess(@ModelAttribute ("withdraw")Account acc, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(as.withdraw(acc.getAccNo(), acc.getAmount()) == null)
            {
                mav.addObject("message", "Cannot Withdraw, Something Wrong with account information!!");
            }
            else
            {
                mav.addObject("message", "Withdraw Successful!!");
            }
            return mav;
        }
    }
    
    @GetMapping("/searchbyname")
    public ModelAndView showSearchForm(HttpSession session)
    {
        ArrayList<Account> accList = new ArrayList<Account>();
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("searchbynameForm");
            mav.addObject("accList", accList);
            mav.addObject("search", new Account());
            return mav;
        }
    }
    @PostMapping("/searchProcess")
    public ModelAndView searchProcess(@ModelAttribute ("search") Account acc, HttpSession session)
    {
        ArrayList<Account> accList = new ArrayList<Account>();
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("searchbynameForm");
            mav.addObject("accList", as.findByName(acc.getName()));
            //mav.addObject("search", new Account());
            return mav;
        }
    }
    
    @GetMapping("/fundtransfer")
    public ModelAndView showFundTransferForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("fundtransferForm");
            mav.addObject("fundDetail", new FundTransferHelperEntity());
            return mav;
        }
    }
    @PostMapping("/fundtransferProcess")
    public ModelAndView processfundTransfer(@ModelAttribute("fundDetail")FundTransferHelperEntity fundTransfer, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            int status = as.fundTransfer(fundTransfer.getSrcAccNo(), fundTransfer.getTrgtAccNo(), fundTransfer.getAmount());
            switch (status)
            {
                case 1:
                       mav.addObject("message", "Source Account doesnot exits!!");
                       break;
                case -1:
                       mav.addObject("message", "Target Account doesnot exits!!");
                       break;
                case 2:
                       mav.addObject("message", "Amount in Source Account is less than the amount you want transfer!!");
                       break;
                case 0:
                       mav.addObject("message", "Fund Transfer Successful!!");   
                       break;
            }
            return mav;
        }
    }
    
    @GetMapping("/accountdetails")
    public ModelAndView showAccountDetailsForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("accountdetailsForm");
            mav.addObject("accountdetails", new Account());
            return mav;
        }
    }
    
    @GetMapping("/editaccountdetails")
    public ModelAndView showEditAccountDetailsForm(@RequestParam int accNo, HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("editaccountdetailsForm");
            mav.addObject("account", as.editAccount(accNo));
            mav.addObject("editaccountdetails", new Account());
            return mav;
        }
    }
    @PostMapping("/editAccountProcess")
    public ModelAndView processeditAccount(@ModelAttribute("editaccountdetails")Account account, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(as.eitAccount(account) == null)
            {
                mav.addObject("message", "Cannot Update Account!!");
            }
            else
            {
                mav.addObject("message", " Account Updated successful!!");
            }
            return mav;
        }
    }
}
