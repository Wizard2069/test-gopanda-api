package com.company.demo.data_body.login;

import com.company.demo.data.customer.CustomerData;
import com.company.demo.data.customer.EmailData;
import com.company.demo.data.customer.Option;

import static com.company.demo.data.customer.Option.*;

public class PostLoginCustomerByEmail extends PostLoginCustomer {
    
    public PostLoginCustomerByEmail(CustomerData data, Option option) {
        super(data, option);
    }
    
    public static PostLoginCustomer createLoginCustomer(String email, String password) {
        CustomerData customer = new EmailData(email, password);
        Option option = new Option(LoginType.email);
    
        PostLoginCustomer loginCustomer = new PostLoginCustomerByEmail(customer, option);
        
        return loginCustomer;
    }
    
}
