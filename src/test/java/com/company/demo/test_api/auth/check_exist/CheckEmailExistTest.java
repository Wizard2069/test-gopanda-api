package com.company.demo.test_api.auth.check_exist;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.CustomerForm;
import com.company.demo.data_body.check_exist.CheckEmailExistCustomer;
import com.company.demo.test_api.auth.Form;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class CheckEmailExistTest {
    
    @Test
    public void shouldVerifySuccessIfAccountDoesNotExist() {
        CustomerForm customer = new CheckEmailExistCustomer(
                "abcd@gmail.com",
                null,
                null,
                null
        );
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(customer))
                .when()
                    .post(BaseUrl.getBaseUrl("/auth/existaccount"))
                .then()
                    .statusCode(200);
    }

    @Test
    public void shouldVerifyErrorIfAccountExist() {
        CustomerForm customer = new CheckEmailExistCustomer(
                "peagoflash@gmail.com",
                null,
                null,
                null
        );
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(customer))
                .when()
                    .post(BaseUrl.getBaseUrl("/auth/existaccount"))
                .then()
                    .statusCode(422)
                    .body("msg", CoreMatchers.equalTo("Account exist"));
    }
    
}
