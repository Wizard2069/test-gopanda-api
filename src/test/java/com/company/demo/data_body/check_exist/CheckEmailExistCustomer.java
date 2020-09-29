package com.company.demo.data_body.check_exist;

import com.company.demo.data_body.CustomerForm;

public class CheckEmailExistCustomer extends CustomerForm {
    
    public CheckEmailExistCustomer(String email, String password, String firebaseId, String invitationCode) {
        super(email, password, firebaseId, invitationCode);
    }
    
}
