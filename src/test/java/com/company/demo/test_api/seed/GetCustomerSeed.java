package com.company.demo.test_api.seed;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetCustomerSeed {
    
    private String token;
    
    @BeforeEach
    public void loginUser() {
        this.token = LoginCustomer.login().path("data.token");
    }
    
    @Test
    public void shouldFailGetCustomerSeed() {
        RestAssured
                .given()
                    .header("Authorization", this.token)
                .when()
                    .post(BaseUrl.getBaseUrl("/api/seed/customer/10"))
                .then()
                    .statusCode(403);
    }
    
}
