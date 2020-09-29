package com.company.demo.test_api.auth.login;

import com.company.demo.BaseUrl;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class PostTokenLoginTest {
    
    private String token =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MzY0MSwiZW1haWwiOiJ0cmFubWluaGhpZXUzMDMyMDBAZ21haWwuY29tIiwibW9iaWxlIjpudWxsLCJleHAiOjE2MDE5MTc5NTB9.g_pbdDanuaMGYmki9QdXS149jVrhLKixX4FaI2lRK6o";
    
    @Test
    public void shouldSuccessLoginCustomer() {
        RestAssured
                .given()
                    .header("Authorization", token)
                .when()
                    .post(BaseUrl.getBaseUrl("/loginWithToken"))
                .then()
                    .statusCode(200)
                    .body("msg", CoreMatchers.equalTo("Get info success"));
    }
    
    @Test
    public void shouldFailLoginCustomer() {
        RestAssured
                .when()
                    .post(BaseUrl.getBaseUrl("/loginWithToken"))
                .then()
                    .statusCode(422);
    }
    
}
