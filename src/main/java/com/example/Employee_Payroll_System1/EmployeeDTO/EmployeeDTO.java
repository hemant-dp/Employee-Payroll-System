package com.example.Employee_Payroll_System1.EmployeeDTO;

import lombok.Data;

import java.time.LocalDate;

//@Data
public class EmployeeDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    private String name;
    private String department;
    private Double salary;
    private LocalDate doj;
}
