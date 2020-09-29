package com.company.demo.test_api.auth.signup;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.CustomerForm;
import com.company.demo.data_body.signup.PostSignUpCustomer;
import com.company.demo.test_api.auth.Form;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class PostEmailSignUpTest {
    
    @Test
    public void shouldSuccessSignUpCustomer() {
        CustomerForm customer = new PostSignUpCustomer(
                "test123@gmail.com",
                "123123",
                null,
                null
        );
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(customer))
                .when()
                    .post(BaseUrl.getBaseUrl("/signUpWithEmail"))
                .then()
                    .statusCode(200)
                    .body("status_code", CoreMatchers.equalTo(200));
    }
    
    @Test
    public void shouldFailSignUpCustomerDueToAccountAlreadyExist() {
        CustomerForm customer = new PostSignUpCustomer(
                "trantuanda2015@gmail.com",
                "123123",
                null,
                null
        );
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(customer))
                .when()
                    .post(BaseUrl.getBaseUrl("/signUpWithEmail"))
                .then()
                    .statusCode(422)
                    .body("status_code", CoreMatchers.equalTo(422));
    }
    
    @Test
    public void shouldFailSignUpCustomerDueToInvalidEmail() {
        CustomerForm invalidCustomer = new PostSignUpCustomer(
                "abc",
                "123123",
                null,
                null
        );
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(invalidCustomer))
                .when()
                    .post(BaseUrl.getBaseUrl("/signUpWithEmail"))
                .then()
                    .statusCode(400);
    }
    
    @Test
    public void shouldFailSignUpCustomerDueToMissingEmail() {
        CustomerForm missingEmailCustomer = new PostSignUpCustomer(
                null,
                "123123",
                null,
                null
        );
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(missingEmailCustomer))
                .when()
                    .post(BaseUrl.getBaseUrl("/signUpWithEmail"))
                .then()
                    .statusCode(400)
                    .body("msg", CoreMatchers.equalTo("Missing params email"));
    }
    
    @Test
    public void shouldFailSignUpCustomerDueToMissingPassword() {
        CustomerForm missingPasswordCustomer = new PostSignUpCustomer(
                "hieutran123@gmail.com",
                null,
                null,
                null
        );
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(Form.createCustomerForm(missingPasswordCustomer))
                .when()
                    .post(BaseUrl.getBaseUrl("/signUpWithEmail"))
                .then()
                    .statusCode(400)
                    .body("msg", CoreMatchers.equalTo("Missing params password"));
    }
    
}
