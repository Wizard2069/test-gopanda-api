package com.company.demo.test_api.auth.verify_info;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import com.company.demo.data_body.verify_info.VerifyEmail;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class VerifyEmailTest {
    
    private Integer customerId;
    
    @BeforeEach
    public void loginCustomer() {
        this.customerId = LoginCustomer.login().path("data.customer.id");
    }
    
    @Test
    public void shouldSuccessVerifyEmail() {
        VerifyEmail info = new VerifyEmail("peagoflash@gmail.com");
        Map<String, String> infoFormParams = new HashMap<>();
        
        infoFormParams.put("email", info.getEmail());
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(infoFormParams)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_email/" + customerId))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Send verify email link success"))
                    .body("data.email_verified", CoreMatchers.equalTo(1));
    }
    
    @Test
    public void shouldFailVerifyEmailDueToInvalidEmail() {
        VerifyEmail info = new VerifyEmail("abc");
        Map<String, String> infoFormParams = new HashMap<>();
        
        infoFormParams.put("email", info.getEmail());
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(infoFormParams)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_email/" + customerId))
                .then()
                    .statusCode(400);
    }
    
}
