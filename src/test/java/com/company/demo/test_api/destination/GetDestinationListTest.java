package com.company.demo.test_api.destination;

import com.company.demo.BaseUrl;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

public class GetDestinationListTest {
    
    @Test
    public void shouldSuccessReturnDestinationList() {
        RestAssured
                .when()
                    .get(BaseUrl.getBaseUrl("/destination/list"))
                .then()
                    .statusCode(200)
                    .body("status", CoreMatchers.equalTo("success"));
    }
    
}
