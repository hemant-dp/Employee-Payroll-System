package com.example.Employee_Payroll_System1.EmpService;


import com.example.Employee_Payroll_System1.EmpEntity.Employee;
import com.example.Employee_Payroll_System1.EmployeeDTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> saveEmployees(List<EmployeeDTO> dtos);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, EmployeeDTO dto);
    void deleteEmployee(Long id);
}
