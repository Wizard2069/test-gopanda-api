package com.company.demo;

import com.company.demo.data_body.login.PostLoginCustomer;
import com.company.demo.data_body.login.PostLoginCustomerByEmail;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginCustomer {
    
    public static Response login() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByEmail
                .createLoginCustomer("trantuanda2016@gmail.com", "1907");
        
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(loginCustomer)
                .when()
                    .post(BaseUrl.getBaseUrl("/login"))
                .then()
                    .extract()
                    .response();
    }
    
}
