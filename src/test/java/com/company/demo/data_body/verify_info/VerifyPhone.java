package com.company.demo.data_body.verify_info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyPhone {
    
    private String mobile;
    private String firebaseId;
}
