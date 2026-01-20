package com.example.Employee_Payroll_System1.EmpController;

import com.example.Employee_Payroll_System1.EmpEntity.Employee;
import com.example.Employee_Payroll_System1.EmpService.EmployeeService;
import com.example.Employee_Payroll_System1.EmployeeDTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:56991")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<List<Employee>> create(@RequestBody List<EmployeeDTO> dtos) {
        return new ResponseEntity<>(service.saveEmployees(dtos), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> fetchAll() {
        return service.getAllEmployees();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
