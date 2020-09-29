package com.company.demo.data_body.login;

import com.company.demo.data.customer.CustomerData;
import com.company.demo.data.customer.Option;
import com.company.demo.data.customer.PhoneData;

import static com.company.demo.data.customer.Option.*;

public class PostLoginCustomerByPhone extends PostLoginCustomer {
    
    public PostLoginCustomerByPhone(CustomerData data, Option option) {
        super(data, option);
    }
    
    public static PostLoginCustomer createLoginCustomer(String mobile, String firebaseId, String invitationCode) {
        CustomerData customer = new PhoneData(mobile, firebaseId, invitationCode);
        Option option = new Option(LoginType.phone);
        
        PostLoginCustomer loginCustomer = new PostLoginCustomerByPhone(customer, option);
        
        return loginCustomer;
    }
    
}
