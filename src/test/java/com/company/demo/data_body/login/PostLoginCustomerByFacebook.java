package com.company.demo.data_body.login;

import com.company.demo.data.customer.CustomerData;
import com.company.demo.data.customer.FacebookData;
import com.company.demo.data.customer.Option;

import static com.company.demo.data.customer.Option.*;

public class PostLoginCustomerByFacebook extends PostLoginCustomer {
    
    public PostLoginCustomerByFacebook(CustomerData data, Option option) {
        super(data, option);
    }
    
    public static PostLoginCustomer createLoginCustomer(String facebookToken) {
        CustomerData customer = new FacebookData(facebookToken);
        Option option = new Option(LoginType.facebook);
        
        PostLoginCustomer loginCustomer = new PostLoginCustomerByFacebook(customer, option);
        
        return loginCustomer;
    }
    
}
