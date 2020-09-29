package com.company.demo.test_api.auth.check_exist;

import com.company.demo.BaseUrl;
import com.company.demo.LoginCustomer;
import com.company.demo.data_body.check_exist.CheckPhoneExistCustomer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckPhoneExistTest {
    
    private Integer customerId;
    
    @BeforeEach
    public void loginCustomer() {
        this.customerId = LoginCustomer.login().path("data.customer.id");
    }
    
    @Test
    public void shouldVerifySuccessIfPhoneDoesNotExist() {
        Map<String, String> customerForm = createCustomerForm("949373598", "+84");
    
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(customerForm)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_phone/phone_valid/" + customerId))
                .then()
                    .statusCode(200);
    }
    
    @Test
    public void shouldVerifyFailDueToMissingPhoneNumber() {
        Map<String, String> customerForm = createCustomerForm(null, "+12");
        
        RestAssured
                .given()
                    .contentType(ContentType.URLENC.withCharset("UTF-8"))
                    .formParams(customerForm)
                .when()
                    .post(BaseUrl.getBaseUrl("/verify_phone/phone_valid/" + customerId))
                .then()
                    .statusCode(400);
    }
    
    private Map<String, String> createCustomerForm(String mobile, String phoneCode) {
        CheckPhoneExistCustomer customer = new CheckPhoneExistCustomer(mobile, phoneCode);
        Map<String, String> customerFormParams = new HashMap<>();
        
        customerFormParams.put("mobile", customer.getMobile());
        customerFormParams.put("phone_code", customer.getPhoneCode());
        
        return customerFormParams;
    }
    
}
