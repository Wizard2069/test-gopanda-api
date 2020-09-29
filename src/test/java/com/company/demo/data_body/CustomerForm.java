package com.company.demo.data_body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CustomerForm {
    
    private String email;
    private String password;
    private String firebaseId;
    private String invitationCode;
}
