package com.data.handler.controller;

import com.data.handler.entity.EmployeeEntity;
import com.data.handler.entity.LoginEntity;
import com.data.handler.request.EmployeeRequestModel;
import com.data.handler.request.LoginModel;
import com.data.handler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @RequestMapping(path = "/masking")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeRequestModel employee){
        return employeeService.addNewEmployee(employee);
    }

    @PostMapping
    @RequestMapping(path = "/signup")
    public ResponseEntity<LoginEntity> signup(@RequestBody LoginModel login){
        return employeeService.addLoginData(login);
    }

    @PostMapping
    @RequestMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginModel login){
        return employeeService.verifyLogin(login);
    }

}
