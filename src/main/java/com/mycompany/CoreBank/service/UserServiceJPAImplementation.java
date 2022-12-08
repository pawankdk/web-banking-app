/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.service;

import com.mycompany.CoreBank.entity.User;
import com.mycompany.CoreBank.respository.UserRepository;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atish Ojha
 */
@Service
public class UserServiceJPAImplementation implements UserService{
    String newPass;
    
    @Autowired
    UserRepository ur;
    @Override
    public User addUser(User u) {
        return ur.save(u);
    }

    @Override
    public User loginUser(User u) {
        User dbUser= ur.findByUname(u.getUname());
        try
        {
            
            if(dbUser.getUpassword().equals(u.getUpassword()))
            {
                return dbUser;
            }
            else
            {
                return null;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println(e);
        } 
        return null; 
    }
    
    @Override
    public Optional<User> findByUid(int uid) {
        return ur.findById(uid);
    }
    @Override
    public User editUser(User u) {
        
        return ur.save(u);
    }

    @Override
    public User createNewUser(User u) {
        User ucc;
        try
        {
            Optional<User> uccResponse = ur.findById(u.getUid());
            if(uccResponse.isPresent())
            {
                return null;
            }
            else
            {
                return ur.save(u);
            }
        }
        catch(NoSuchElementException ex)
        {
            System.out.println(ex);
        }
        
        return null;
    }

    @Override
    public User forgetPassword(User u) {
        User dbUser= ur.findByUname(u.getUname());
        User ucc;
        try
        {
            Optional<User> accResponse =ur.findById(u.getUid());
            if(accResponse.isPresent())
            {
                try
                {
                    if((dbUser.getUid()==(u.getUid()))& (dbUser.getUname().equals(u.getUname())))
                    {
                        return ur.save(u);  
                    }
                }
                catch(NullPointerException e)
                {
                    System.out.println(e);
                }
                
                                             
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

    @Override
    public User changePassword(User u) {
        User dbUser= ur.findByUname(u.getUname());
        User ucc;
        try
        {
            Optional<User> accResponse =ur.findById(u.getUid());
            if(accResponse.isPresent())
            {
                try
                {               
                        return ur.save(u);  
                }
                catch(NullPointerException e)
                {
                    System.out.println(e);
                }                              
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
