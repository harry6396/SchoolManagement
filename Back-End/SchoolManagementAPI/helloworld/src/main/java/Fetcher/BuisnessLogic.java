/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fetcher;

import com.schoolmanagement.helloworld.Model.Login;
import com.schoolmanagement.helloworld.Model.TeacherDetail;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prabhat
 */
public class BuisnessLogic {
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static Login tokenGenerator(Login userDetails){
        Connection con = DataFetcher.connectionEstablish();
        String token = generateNewToken();
        Login login = new Login();
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE Roles "
                    + "SET Token='"+token+"' WHERE Id='"+userDetails.getUserId()
                    +"' AND Password='"+userDetails.getUserPassword()+"';";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(sql+" -> "+affectedRows);
            if(affectedRows>0){
                login.setUserId(userDetails.getUserId());
                login.setToken(token);
                login.setMessage("Success");
            }
            else{
                login.setMessage("Fail");
            }
            return login;
        } catch (SQLException ex) {
            Logger.getLogger(BuisnessLogic.class.getName()).log(Level.SEVERE, null, ex);
            login.setMessage(ex.getMessage());
            return login;
        }
    }
    public static Login tokenChecker(Login tokenDetails){
        Connection con = DataFetcher.connectionEstablish();
        String token = generateNewToken();
        Login login = new Login();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT Id, Token"
                    + " FROM Roles WHERE Id='" + tokenDetails.getUserId()
                    + "' AND Token='" + tokenDetails.getToken() + "';";
            ResultSet rst = stmt.executeQuery(sql);
            if (rst!=null) {
                login.setUserId(tokenDetails.getUserId());
                login.setToken(token);
                login.setMessage("Success");
            } else {
                login.setMessage("Fail");
            }
            return login;
        } catch (SQLException ex) {
            Logger.getLogger(BuisnessLogic.class.getName()).log(Level.SEVERE, null, ex);
            login.setMessage(ex.getMessage());
            return login;
        } 
    }
    public static Login logoutUser(Login userDetails){
        Connection con = DataFetcher.connectionEstablish();
        String token = generateNewToken();
        Login login = new Login();
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE Roles "
                    + "SET Token='" + null + "' WHERE Id='" + userDetails.getUserId()
                    + "' AND Token='" + userDetails.getToken()+ "';";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(sql + " -> " + affectedRows);
            if (affectedRows > 0) {
                login.setUserId(userDetails.getUserId());
                login.setToken(token);
                login.setMessage("Success");
            } else {
                login.setMessage("Fail");
            }
            return login;
        } catch (SQLException ex) {
            Logger.getLogger(BuisnessLogic.class.getName()).log(Level.SEVERE, null, ex);
            login.setMessage(ex.getMessage());
            return login;
        }
    }
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    public static TeacherDetail getUserDetails(Login resource){
        TeacherDetail teacherDetail = new TeacherDetail();
        Connection con = DataFetcher.connectionEstablish();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT FirstName, LastName, DOJ, PermanentAddress,"
                    + " CorrespondenceAddress, PhoneNumber, EmailID, PreviousSchool"
                    + " FROM Teacher T INNER JOIN Roles R ON T.TeacherID=R.ID"
                    + " WHERE R.Token='"+resource.token+"'";
            ResultSet rst = stmt.executeQuery(sql);
            if (rst!=null) {
                teacherDetail.setFirstName(rst.getString("FirstName"));
                teacherDetail.setLastName(rst.getString("LastName"));
                teacherDetail.setDateOfJoining(rst.getString("DOJ"));
                teacherDetail.setPermanentAddress(rst.getString("PermanentAddress"));
                teacherDetail.setCorrespondanceAddress(rst.getString("CorrespondenceAddress"));
                teacherDetail.setPhoneNumber(rst.getString("PhoneNumber"));
                teacherDetail.setEmailID(rst.getString("EmailID"));
                teacherDetail.setPreviousSchool(rst.getString("PreviousSchool"));
                teacherDetail.setMessage("Success");
                return teacherDetail;
            } else {
                teacherDetail.setMessage("Fail");
            }
            return teacherDetail;
        } catch (SQLException ex) {
            Logger.getLogger(BuisnessLogic.class.getName()).log(Level.SEVERE, null, ex);
            teacherDetail.setMessage(ex.getMessage());
            return teacherDetail;
        } 
    }
}
