/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schoolmanagement.management.mavenproject.Model;

/**
 *
 * @author Prabhat
 */
public class Token {
    public String token;
    public String tokenDescription;

    public String getToken() {
        return token;
    }

    public String getTokenDescription() {
        return tokenDescription;
    }

    public void setTokenDescription(String tokenDescription) {
        this.tokenDescription = tokenDescription;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
