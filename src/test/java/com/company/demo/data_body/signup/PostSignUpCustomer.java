package com.company.demo.data_body.signup;

import com.company.demo.data_body.CustomerForm;

public class PostSignUpCustomer extends CustomerForm {
    
    public PostSignUpCustomer(String email, String password, String firebaseId, String invitationCode) {
        super(email, password, firebaseId, invitationCode);
    }
}
