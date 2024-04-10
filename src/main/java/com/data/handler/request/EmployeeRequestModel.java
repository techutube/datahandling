package com.data.handler.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequestModel {
    private String email;
    private String pan;
    private String aadhaar;
    private String creditCard;
}
