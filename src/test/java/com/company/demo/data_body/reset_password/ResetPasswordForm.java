package com.company.demo.data_body.reset_password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ResetPasswordForm {
    
    private String email;
    private String password;
    private String oobcode;
}
