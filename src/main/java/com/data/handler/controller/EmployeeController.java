package com.data.handler.controller;

import com.data.handler.entity.EmployeeEntity;
import com.data.handler.request.EmployeeRequestModel;
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

    /*public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
        return employeeService.getAllEmployee();
    }*/

}
