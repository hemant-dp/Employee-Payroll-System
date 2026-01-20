import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee-service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-payroll',
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-payroll.html',
  styleUrl: './employee-payroll.css',
})
export class EmployeePayroll implements OnInit {
  employees: Employee[] = [];
  newEmployee: Employee = { name: '', department: '', salary: 0, doj: '' };

  constructor(
    private service: EmployeeService,
    private cdr: ChangeDetectorRef // Inject this
  ) {}

  ngOnInit(): void { this.fetchEmployees(); }

  fetchEmployees() {
     this.service.getAllEmployees().subscribe({
    next: (data) => {
      console.log("Fetched employees:", data); // Add this line
      this.employees = [...data];
      this.cdr.detectChanges();
    },
    error: (err) => console.error("Fetch failed", err)
  });
}

  onAdd() {
    if(!this.newEmployee.name) return; // Basic validation
    
    // Clone the object to avoid reference issues
    const employeeToAdd = { ...this.newEmployee };

    this.service.saveEmployees([employeeToAdd]).subscribe({
      next: (data) => {
        console.log("Added successfully!");
        this.newEmployee = { name: '', department: '', salary: 0, doj: '' }; // Reset after success
        this.fetchEmployees(); // Then fetch new list
      },
      error: (err) => console.error("Add failed", err)
    });
  }

  onDelete(id: number | undefined) {
    if (id !== undefined) {
      this.service.deleteEmployee(id).subscribe({
        next: (res) => {
          console.log("Deleted successfully");
          this.fetchEmployees(); // Immediate refresh
        },
        error: (err) => {
          console.error("Delete failed", err);
          this.fetchEmployees(); // Refresh even on error to sync UI with DB
        }
      });
    }
  }

}