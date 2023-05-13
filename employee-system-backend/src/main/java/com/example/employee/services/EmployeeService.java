package com.example.employee.services;

import com.example.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employee);

    List<EmployeeDTO> getAllEmployees();

    boolean deleteEmployee(Long id);

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employee);
}
