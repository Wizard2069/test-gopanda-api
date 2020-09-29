package com.company.demo.data_body.login;

import com.company.demo.data.customer.CustomerData;
import com.company.demo.data.customer.Option;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PostLoginCustomer {
    
    private CustomerData data;
    private Option option;
}
