package com.company.demo.data.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailData implements CustomerData {
    
    private String email;
    private String password;
}
