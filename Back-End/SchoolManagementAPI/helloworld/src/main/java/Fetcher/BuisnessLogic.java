/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fetcher;

import com.schoolmanagement.helloworld.Model.Login;
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
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
