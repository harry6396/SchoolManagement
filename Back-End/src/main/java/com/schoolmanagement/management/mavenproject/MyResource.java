package com.schoolmanagement.management.mavenproject;

import com.schoolmanagement.management.mavenproject.Model.Token;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

@Path("myresource")
public class MyResource {

    @GET
    @Path("tokenGenerator")
    @Produces(MediaType.APPLICATION_JSON)
    public String generateToken() {
        DataFetcher dataFetcher = new DataFetcher("");
        Token token = new Token();
        if(dataFetcher == null){
            return null;
        }
        else{
            String generatedToken = TokenGenerator.tokenGenerator();
            token.setToken(generatedToken);
            token.setTokenDescription("User token");
            Gson gson = new Gson();
            String jsonResp = gson.toJson(token);
            return jsonResp;
        }
    }
}
