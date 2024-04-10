package com.data.handler.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponseModel {
    private String name;
    private String pan;
    private String aadhaar;
    private String creditCard;
}
