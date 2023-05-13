package com.example.employee.dto;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.model.Employee;

public class EmployeeConverter {

    public static EmployeeDTO entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setEmailId(employeeEntity.getEmailId());
        return employeeDTO;
    }

    public static EmployeeEntity dtoToEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setEmailId(employeeDTO.getEmailId());
        return employeeEntity;
    }

    public static EmployeeDTO modelToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmailId(employee.getEmailId());
        return employeeDTO;
    }

    public static Employee dtoToModel(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        return employee;
    }
}
