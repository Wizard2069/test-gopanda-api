package com.company.demo.data.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneData implements CustomerData {

    private String mobile;
    private String firebaseid;
    private String invitation_code;
}
