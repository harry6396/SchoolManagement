
package com.schoolmanagement.management.mavenproject.Model;

public class User {
    private String userName;
    private String emailId;
    private String mobileNo;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    
    public String getUserName(){
        return this.userName;
    }
    public String getEmailID(){
        return this.emailId;
    }
    public String getMobileNo(){
        return this.mobileNo;
    }
    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    public String getDOB(){
        return this.dob;
    }
    public String getAddress(){
        return this.address;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setEmailID(String emailId){
        this.emailId = emailId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }
    public void setDOB(String dob){
        this.dob = dob;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
