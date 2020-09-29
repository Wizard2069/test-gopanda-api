package com.company.demo.test_api.auth.reset_password;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.reset_password.PreResetPassword;
import com.company.demo.data_body.reset_password.ResetPasswordForm;
import com.company.demo.test_api.auth.Form;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class PreResetPasswordTest {

    @Test
    public void shouldSuccessSendEmail() {
        ResetPasswordForm preReset = new PreResetPassword("trantuanda2016@gmail.com");
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createResetPasswordForm(preReset))
                .when()
                    .post(BaseUrl.getBaseUrl("/pre_resetpwd"))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Send email success"));
    }
    
    @Test
    public void shouldFailSendEmailDueToEmailNotExist() {
        ResetPasswordForm preReset = new PreResetPassword("abc@gmail.com");
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createResetPasswordForm(preReset))
                .when()
                    .post(BaseUrl.getBaseUrl("/pre_resetpwd"))
                .then()
                    .statusCode(400)
                    .body("msg", CoreMatchers.equalTo("Email not exist"));
    }
    
}
