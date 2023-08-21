package com.example.RegisterUser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterUser.Dto.EmployeeDTO;
import com.example.RegisterUser.entity.Employee;
import com.example.RegisterUser.repo.EmployeeRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService 
 {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) 
       {

        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getUsername(),
                employeeDTO.getAddress(),
                employeeDTO.getMobile(),
                employeeDTO.getPassword(),
                employeeDTO.getCreatedAt()
        );
        employeeRepo.save(employee);
        return employee.getUsername();
    }
	
}