package com.company.demo.data.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    
    private LoginType type;
    
    public enum LoginType {
        email, phone, facebook
    }
}
