package com.company.demo.test_api.auth.login;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.login.PostLoginCustomer;
import com.company.demo.data_body.login.PostLoginCustomerByEmail;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostEmailLoginTest {
    
    private String token;
    
    @Test
    public void shouldSuccessLoginCustomer() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByEmail
                .createLoginCustomer("trantuanda2016@gmail.com", "1907");
        
        this.token = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(loginCustomer)
                .when()
                    .post(BaseUrl.getBaseUrl("/login"))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Login success"))
                .extract()
                    .path("data.token");
    
        Assertions.assertNotNull(this.token);
    }
    
    @Test
    public void shouldFailLoginCustomerDueToNotHaveAccountYet() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByEmail
                .createLoginCustomer("abc@gmail.com", "111222");
        
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(loginCustomer)
                .when()
                    .post(BaseUrl.getBaseUrl("/login"))
                .then()
                    .statusCode(422);
    }
    
    @Test
    public void shouldFailLoginCustomerDueToInvalidInfo() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByEmail
                .createLoginCustomer(null, null);
        
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(loginCustomer)
                .when()
                    .post(BaseUrl.getBaseUrl("/login"))
                .then()
                    .statusCode(422);
    }
    
}
