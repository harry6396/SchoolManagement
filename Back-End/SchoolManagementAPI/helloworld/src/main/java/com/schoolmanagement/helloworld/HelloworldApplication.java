package com.schoolmanagement.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/payment")
public class HelloworldApplication {
        private final String sharedKey = "SHARED_KEY";
        private static final String SUCCESS_STATUS = "success";
        private static final String ERROR_STATUS = "error";
        private static final int CODE_SUCCESS = 100;
        private static final int AUTH_FAILURE = 102;
        @RequestMapping(value = "/pay", method = RequestMethod.POST)
        public BaseResponse pay(@RequestParam(value = "key") String key) {
        BaseResponse response = new BaseResponse();
        
        response.setStatus(SUCCESS_STATUS);
        response.setCode(CODE_SUCCESS);
        return response;
        }
        @RequestMapping(value = "/pay1", method = RequestMethod.GET)
        public BaseResponse pay1(@RequestParam(value = "key") String key) {
        BaseResponse response = new BaseResponse();
        
        response.setStatus(SUCCESS_STATUS);
        response.setCode(CODE_SUCCESS);
        return response;
        }
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
