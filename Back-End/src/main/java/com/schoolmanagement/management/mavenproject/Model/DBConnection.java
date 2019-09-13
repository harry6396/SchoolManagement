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
public class DBConnection {
    public String sDBName;
    public String sHostName;
    public String sUserName;
    public String sPassword;

    public String getsDBName() {
        return sDBName;
    }

    public void setsDBName(String sDBName) {
        this.sDBName = sDBName;
    }

    public String getsHostName() {
        return sHostName;
    }

    public void setsHostName(String sHostName) {
        this.sHostName = sHostName;
    }

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
    
}
