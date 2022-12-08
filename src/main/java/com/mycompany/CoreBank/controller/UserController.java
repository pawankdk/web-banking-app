/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.controller;

import com.mycompany.CoreBank.entity.Account;
import com.mycompany.CoreBank.entity.User;
import com.mycompany.CoreBank.service.UserService;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Atish Ojha
 */
@Controller
public class UserController {
    @Autowired
    UserService us;
    @GetMapping("/")
    public ModelAndView showHomePage()
    {
        ModelAndView mav = new ModelAndView("loginForm");
        mav.addObject("newUser", new User());
        return mav;
    }
    
    @GetMapping("/logout")
    public ModelAndView showLoginPage(HttpSession session)
    {
        session.invalidate();
        return showHomePage();
    }
    
    @PostMapping("/loginProcess")
    public ModelAndView processLogin(@ModelAttribute("newUser")User user,HttpSession session)
    {
        ModelAndView mav = new ModelAndView();
        User loggedInUser = us.loginUser(user);
        session.setAttribute("userid", loggedInUser.getUid());
        session.setAttribute("userpassword", loggedInUser.getUpassword());
        if(loggedInUser != null)
        {
            mav.setViewName("dashboard");
            mav.addObject("message", "Welcome to Core Banking System.");
            session.setAttribute("username", loggedInUser.getUname());
        }
        else
        {
            mav.setViewName("loginForm");
            mav.addObject("message", "Cannot LogIn");
        }
        return mav;
    }
    
    @GetMapping("/forgetpassword")
    public ModelAndView showForgetPassword()
    {
        ModelAndView mav = new ModelAndView("forgetpasswordForm");
        mav.addObject("forgetpassword", new User());
        return mav;
    }
    
    @PostMapping("/forgetpasswordProcess")
    public ModelAndView showForgetPasswordProcess(@ModelAttribute("forgetpassword")User user)
    {
        ModelAndView mav = new ModelAndView("forgetpasswordForm");
        if(us.forgetPassword(user) == null)
        {
            mav.addObject("message", "Cannot Reset Password ID or User Name not match!!");
        }
        else
        {
            mav.addObject("message", " Password Reset successful!!");
        }
        return mav;
    }
    
    @GetMapping("/registerUser")
    public ModelAndView showRegisterUserForm()
    {
        ModelAndView mav = new ModelAndView("userregisterForm");
        mav.addObject("registerUser", new User());
        return mav;
    }
    @PostMapping("/registerUserProcess")
    public ModelAndView processNewAccount(@ModelAttribute("newUser")User user)
    {
        ModelAndView mav = new ModelAndView("loginForm");
        if(us.createNewUser(user) == null)
        {
            mav.addObject("message", "Cannot Create New User, May be User Number is already taken!!");
        }
        else
        {
            mav.addObject("message", "New User Creation successful!!");
        }
        return mav;
    }
    
    @GetMapping("/editprofile")
    public ModelAndView showEditProfileForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("edituserForm");
            mav.addObject("editprofile", new User());
            return mav;
        }
    }
    @PostMapping("/editUserProcess")
    public ModelAndView processeditAccount(@ModelAttribute("editprofile")User user, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(us.editUser(user) == null)
            {
                mav.addObject("message", "Cannot Edit User!!");
            }
            else
            {
                mav.addObject("message", " User Updated successful!!");
            }
            return mav;
        }
    }
    
     @GetMapping("/changepassword")
    public ModelAndView showChangePasswordForm(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("changepasswordForm");
            mav.addObject("changepassword", new User());
            return mav;
        }
    }
    @PostMapping("/changepasswordProcess")
    public ModelAndView processchangePassword(@ModelAttribute("changepassword")User user, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null)
        {
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        else
        {
            if(us.changePassword(user) == null)
            {
                mav.addObject("message", "Cannot Change Password of User!!");
            }
            else
            {
                mav.addObject("message", " User Password Changed successful!!");
            }
            return mav;
        }
    }
    
    
}
