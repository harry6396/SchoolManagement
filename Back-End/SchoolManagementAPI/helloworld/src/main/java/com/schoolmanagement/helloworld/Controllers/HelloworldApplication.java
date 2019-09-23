package com.schoolmanagement.helloworld.Controllers;

import Fetcher.BuisnessLogic;
import com.schoolmanagement.helloworld.Model.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/schoolmanagement")
public class HelloworldApplication {
        private final String sharedKey = "SHARED_KEY";
        
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public Login token(@RequestParam(value = "key") String key, @RequestBody Login resource) {
            return BuisnessLogic.tokenGenerator(resource);
        }
        
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
