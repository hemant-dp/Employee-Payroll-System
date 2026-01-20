package com.example.Employee_Payroll_System1.EmpServiceImp;


import com.example.Employee_Payroll_System1.EmpEntity.Employee;
import com.example.Employee_Payroll_System1.EmpRepository.EmployeeRepository;
import com.example.Employee_Payroll_System1.EmpService.EmployeeService;
import com.example.Employee_Payroll_System1.EmployeeDTO.EmployeeDTO;
import com.example.Employee_Payroll_System1.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> saveEmployees(List<EmployeeDTO> dtos) {
        // 1. Convert List of DTOs to List of Entities
        List<Employee> employees = dtos.stream().map(dto -> {
            Employee emp = new Employee();
            emp.setName(dto.getName());
            emp.setDepartment(dto.getDepartment());
            emp.setSalary(dto.getSalary());
            emp.setDoj(dto.getDoj());
            return emp;
        }).collect(Collectors.toList());

        // 2. Use saveAll to store everything in one go
        return repository.saveAll(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. ID " + id + " not found.");
        }
        repository.deleteById(id);
    }
}