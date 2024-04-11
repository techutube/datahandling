package com.data.handler.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginModel {
    private String username;
    private String password;
}
