package com.data.handler.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashUtil {

    @Autowired
    PasswordEncoder passwordEncoder;
    public String convertToHash(String string){
        return passwordEncoder.encode(string);
    }

    public boolean verify(String value, String hash){
        return passwordEncoder.matches(value, hash);
    }

}
