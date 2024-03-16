package org.example.service;

import org.example.dto.EmployeeRepository;
import org.example.model.Employee;
import org.example.model.EmployeeEvent;
import org.example.processor.EmployeeProducer;
import org.example.response.AddEmployeeresponse;
import org.example.response.DeleteEmployeeresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeProducer employeeProducer;

    public AddEmployeeresponse createEmployee(Employee employee){

        Employee oldemployee=null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent())
        {
            oldemployee=optionalEmployee.get();
            oldemployee.setName(employee.getName());
            oldemployee.setDepartment(employee.getDepartment());
            oldemployee.setSalary(employee.getSalary());
            oldemployee.setDesignation(employee.getDesignation());
            employeeRepository.save(oldemployee);
            return new AddEmployeeresponse("updated the employee details successfully");
        }
        else
        {
            employeeRepository.save(employee);
            return new AddEmployeeresponse("created new employee details successfully");
        }
    }

    public DeleteEmployeeresponse deleteEmployee(String empid)
    {
        Employee employee=null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(parseInt(empid));
        if(optionalEmployee.isPresent())
        {
            EmployeeEvent event = EmployeeEvent.newBuilder()
                    .setId(optionalEmployee.get().getId())
                    .setName(optionalEmployee.get().getName())
                    .setDepartment(optionalEmployee.get().getDepartment())
                    .setDesignation(optionalEmployee.get().getDesignation())
                    .setSalary(optionalEmployee.get().getSalary())
                    .setLastworkingday(new Date().toInstant().toEpochMilli()).build();
            employeeProducer.produceEmployee(event);
            employeeRepository.deleteById(Integer.valueOf(empid));
            return new DeleteEmployeeresponse("successfully deleted employee record");
        }
        else {
            return new DeleteEmployeeresponse("No employee record found");
        }
    }
}
