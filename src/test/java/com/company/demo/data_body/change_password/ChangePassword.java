package com.company.demo.data_body.change_password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {
    
    private String oldPassword;
    private String newPassword;
}
