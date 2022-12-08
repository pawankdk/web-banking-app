/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoreBank.respository;

import com.mycompany.CoreBank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Atish Ojha
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByUname(String name);
}
