package com.company.demo.data_body.check_exist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckPhoneExistCustomer {
    
    private String mobile;
    private String phoneCode;
}
