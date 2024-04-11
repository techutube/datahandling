package com.data.handler.service;

import com.data.handler.entity.EmployeeEntity;
import com.data.handler.entity.LoginEntity;
import com.data.handler.enums.MaskingEnum;
import com.data.handler.repository.EmployeeRepository;
import com.data.handler.repository.LoginRepository;
import com.data.handler.request.EmployeeRequestModel;
import com.data.handler.request.LoginModel;
import com.data.handler.util.HashUtil;
import com.data.handler.util.MaskingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    HashUtil hashUtil;

    @Autowired
    MaskingClass maskingClass;
    public ResponseEntity<EmployeeEntity> addNewEmployee(EmployeeRequestModel employee) {
        EmployeeEntity entity = EmployeeEntity.builder()
                .pan(maskingClass.mask(employee.getPan(), MaskingEnum.PAN))
                .aadhaar(maskingClass.mask(employee.getAadhaar(), MaskingEnum.AADHAAR))
                .creditCard(maskingClass.mask(employee.getCreditCard(), MaskingEnum.CREDIT_CARD))
                .email(maskingClass.mask(employee.getEmail(), MaskingEnum.DEFAULT))
                .build();
        return ResponseEntity.ok(employeeRepository.save(entity));
    }


    public ResponseEntity<LoginEntity> addLoginData(LoginModel login) {
        LoginEntity entity = LoginEntity.builder()
                .username(login.getUsername())
                .password(hashUtil.convertToHash(login.getPassword()))
                .build();
        loginRepository.save(entity);
        return ResponseEntity.ok(loginRepository.save(entity));
    }

    public ResponseEntity<String> verifyLogin(LoginModel login) {
        if(loginRepository.findByUsername(login.getUsername()).isPresent())
            if(hashUtil.verify(login.getPassword(), hashUtil.convertToHash(login.getPassword())))
                return ResponseEntity.ok("|||||||||||  Successfully Logged In  |||||||||||||||||");

        return ResponseEntity.ok("xxxxx Invalid Credentials xxxxxxxxx");
    }
}
