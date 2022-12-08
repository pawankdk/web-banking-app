/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.service;

import com.mycompany.CoreBank.entity.Account;
import com.mycompany.CoreBank.entity.User;
import java.util.Optional;

/**
 *
 * @author Atish Ojha
 */
public interface UserService {
    public User createNewUser(User u);
    public User addUser(User u);
    public User loginUser(User u);
    public User editUser(User u);
    public User forgetPassword(User u);
    public User changePassword(User u);
    public Optional<User> findByUid(int uid);
}
