package com.company.demo.test_api.auth;

import com.company.demo.data_body.CustomerForm;
import com.company.demo.data_body.change_password.ChangePassword;
import com.company.demo.data_body.reset_password.PreResetPassword;
import com.company.demo.data_body.reset_password.ResetPasswordForm;

import java.util.HashMap;
import java.util.Map;

public class Form {
    
    public static Map<String, String> createCustomerForm(CustomerForm customer) {
        Map<String, String> signUpFormParams = new HashMap<>();
        
        signUpFormParams.put("email", customer.getEmail());
        signUpFormParams.put("password", customer.getPassword());
        signUpFormParams.put("firebaseid", customer.getFirebaseId());
        signUpFormParams.put("invitation_code", customer.getInvitationCode());
        
        return signUpFormParams;
    }
    
    public static Map<String, String> createChangePasswordForm(ChangePassword change) {
        Map<String, String> changePasswordParams = new HashMap<>();
        
        changePasswordParams.put("old_password", change.getOldPassword());
        changePasswordParams.put("new_password", change.getNewPassword());
        
        return changePasswordParams;
    }
    
    public static Map<String, String> createResetPasswordForm(ResetPasswordForm reset) {
        Map<String, String> resetPassword = new HashMap<>();
        
        resetPassword.put("email", reset.getEmail());
        resetPassword.put("password", reset.getPassword());
        resetPassword.put("oobcode", reset.getOobcode());
        
        return resetPassword;
    }
    
}
