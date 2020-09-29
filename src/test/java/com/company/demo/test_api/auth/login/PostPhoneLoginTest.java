package com.company.demo.test_api.auth.login;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.login.PostLoginCustomer;
import com.company.demo.data_body.login.PostLoginCustomerByPhone;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostPhoneLoginTest {
    
    private String token;
    
    @Test
    public void shouldSuccessLoginCustomer() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByPhone
                .createLoginCustomer("09812442747", "12312378", "E10mA");
        
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
    public void shouldFailLoginCustomerDueToInvalidInfo() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByPhone
                .createLoginCustomer(null, null, null);
        
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
