package com.company.demo.test_api.auth.change_password;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import com.company.demo.data_body.change_password.ChangePassword;
import com.company.demo.test_api.auth.Form;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest {
    
    private String token;
    
    @BeforeEach
    public void loginCustomer() {
        this.token = "Bearer " + LoginCustomer.login();
    }
    
    @Test
    public void shouldSuccessChangePassword() {
        ChangePassword change = new ChangePassword("1907", "123123");
        
        RestAssured
                .given()
                    .header("Authorization", this.token)
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createChangePasswordForm(change))
                .when()
                    .post(BaseUrl.getBaseUrl("/changepwd"))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Change password success"));
    }
    
    @Test
    public void shouldFailChangePasswordDueToWrongOldPassword() {
        ChangePassword change = new ChangePassword("1111", "123123");
    
        RestAssured
                .given()
                    .header("Authorization", this.token)
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createChangePasswordForm(change))
                .when()
                    .post(BaseUrl.getBaseUrl("/changepwd"))
                .then()
                    .statusCode(422)
                    .body("msg", CoreMatchers.equalTo("Old password wrong"));
    }
    
    @Test
    public void shouldFailChangePasswordDueToMissingNewPassword() {
        ChangePassword change = new ChangePassword("1907", null);
        
        RestAssured
                .given()
                    .header("Authorization", this.token)
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createChangePasswordForm(change))
                .when()
                    .post(BaseUrl.getBaseUrl("/changepwd"))
                .then()
                    .statusCode(400);
    }
    
}
