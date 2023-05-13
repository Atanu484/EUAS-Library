package com.example.employee.services;

import com.example.employee.dto.EmployeeConverter;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = EmployeeConverter.dtoToEntity(employee);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return EmployeeConverter.entityToDto(savedEntity);
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if (employeeEntity != null) {
            return EmployeeConverter.entityToDto(employeeEntity);
        }
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employee) {
        if (employeeRepository.existsById(id)) {
            EmployeeEntity updatedEntity = EmployeeConverter.dtoToEntity(employee);
            updatedEntity.setId(id);  // Ensure the id remains the same
            EmployeeEntity savedEntity = employeeRepository.save(updatedEntity);
            return EmployeeConverter.entityToDto(savedEntity);
        }
        return null;
    }
}
