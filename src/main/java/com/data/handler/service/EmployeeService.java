package com.data.handler.service;

import com.data.handler.entity.EmployeeEntity;
import com.data.handler.enums.MaskingEnum;
import com.data.handler.repository.EmployeeRepository;
import com.data.handler.request.EmployeeRequestModel;
import com.data.handler.util.MaskingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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

}
