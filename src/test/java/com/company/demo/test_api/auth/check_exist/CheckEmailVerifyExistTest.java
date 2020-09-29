package com.company.demo.test_api.auth.check_exist;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import com.company.demo.data_body.verify_info.VerifyEmail;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckEmailVerifyExistTest {

    private Integer customerId;
    
    @BeforeEach
    public void loginCustomer() {
        this.customerId = LoginCustomer.login().path("data.customer.id");
    }
    
    @Test
    public void shouldSuccessCheckEmailVerify() {
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(createEmailForm("abc@gmail.com"))
                .when()
                    .post(BaseUrl.getBaseUrl("/verify/mail_valid/" + customerId))
                .then()
                    .statusCode(200);
    }
    
    @Test
    public void shouldFailCheckEmailVerifyDueToAccountAlreadyExist() {
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(createEmailForm("peagoflash@gmail.com"))
                .when()
                    .post(BaseUrl.getBaseUrl("/verify/mail_valid/" + customerId))
                .then()
                    .statusCode(422);
    }
    
    private Map<String, String> createEmailForm(String email) {
        VerifyEmail verifyEmail = new VerifyEmail(email);
        Map<String, String> emailFormParams = new HashMap<>();
        
        emailFormParams.put("email", verifyEmail.getEmail());
        
        return emailFormParams;
    }
    
}
