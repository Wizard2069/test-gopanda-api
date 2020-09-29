package com.company.demo.test_api.auth.verify_info;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import com.company.demo.data_body.verify_info.VerifyPhone;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class VerifyPhoneTest {
    
    private Integer customerId;
    
    @BeforeEach
    public void loginCustomer() {
        this.customerId = LoginCustomer.login().path("data.customer.id");
    }
    
    @Test
    public void shouldSuccessVerifyPhone() {
        Map<String, String> infoFormParams = createInfoForm("0398055599", "121321312");
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(infoFormParams)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_phone/" + customerId))
                .then()
                    .statusCode(200)
                    .body("data.phone_verified", CoreMatchers.equalTo(1))
                    .body("data.mobile", CoreMatchers.equalTo(infoFormParams.get("mobile")));
    }
    
    @Test
    public void shouldFailVerifyPhoneDueToMissingPhoneNumber() {
        Map<String, String> infoFormParams = createInfoForm(null, null);
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(infoFormParams)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_phone/" + customerId))
                .then()
                    .statusCode(400);
    }
    
    private Map<String, String> createInfoForm(String mobile, String firebaseId) {
        VerifyPhone info = new VerifyPhone(mobile, firebaseId);
        Map<String, String> infoFormParams = new HashMap<>();
    
        infoFormParams.put("mobile", info.getMobile());
        infoFormParams.put("firebaseid", info.getFirebaseId());
        
        return infoFormParams;
    }
    
}
