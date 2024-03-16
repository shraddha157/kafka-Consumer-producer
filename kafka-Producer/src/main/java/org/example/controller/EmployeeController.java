package org.example.controller;

import org.example.model.Employee;
import org.example.response.AddEmployeeresponse;
import org.example.response.DeleteEmployeeresponse;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/addemployee")
    public AddEmployeeresponse addEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.createEmployee(employee)).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteEmployeeresponse> deleteEmployee(@PathVariable("id") String id)
    {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
