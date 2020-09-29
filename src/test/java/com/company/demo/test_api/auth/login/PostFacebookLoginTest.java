package com.company.demo.test_api.auth.login;

import com.company.demo.BaseUrl;
import com.company.demo.data_body.login.PostLoginCustomer;
import com.company.demo.data_body.login.PostLoginCustomerByFacebook;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostFacebookLoginTest {

    private String facebookToken =
            "EAAHtYV6w24sBAAGCO8j0IIF1Mbs3Cus9Mxgok8BXzBgOpMBsjL0VKZCKOIZCQgOoSKZCgbDUWCCHasX4Ts5zwUIutNC9WuYN2uf04dv9IvuNQxBZBzSNzxW59OrzjcGzszV7lAZCKJfJE0jZAO4tAxabaGYAqJf7lpXe9vmnCF2cSHdU3bBK67IYw7I7HASKqX3b7sQ6couyAFC4BBi7FGPZBl60nnqr9bZCMu2wCOQUvCUANPdBcFz7";
    private String token;
    
    @Test
    public void shouldSuccessLoginCustomer() {
        PostLoginCustomer loginCustomer = PostLoginCustomerByFacebook.createLoginCustomer(facebookToken);
    
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
        PostLoginCustomer loginCustomer = PostLoginCustomerByFacebook.createLoginCustomer(null);
        
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
