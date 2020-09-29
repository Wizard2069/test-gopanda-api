package com.company.demo.test_api.auth.reset_password;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.reset_password.ConfirmResetPassword;
import com.company.demo.data_body.reset_password.ResetPasswordForm;
import com.company.demo.test_api.auth.Form;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class ConfirmResetPasswordTest {
    
    @Test
    public void shouldSuccessResetPassword() {
        String oobcode = "EAMcdi_wBAeSWG5VtB2CdzTIg5otL8JMfKeyakxWAV4AAAFvhfcfzA";
        
        ResetPasswordForm reset = new ConfirmResetPassword(
                "dongoctien97@gmail.com",
                "123123",
                oobcode
        );
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createResetPasswordForm(reset))
                .when()
                    .post(BaseUrl.getBaseUrl("/confirm_resetpwd"))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Change password success"));
    }
    
    @Test
    public void shouldFailResetPasswordDueToInvalidOobCode() {
        ResetPasswordForm reset = new ConfirmResetPassword(
                "dongoctien97@gmail.com",
                "123123",
                null
        );
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createResetPasswordForm(reset))
                .when()
                    .post(BaseUrl.getBaseUrl("/confirm_resetpwd"))
                .then()
                    .statusCode(400);
    }
    
}
