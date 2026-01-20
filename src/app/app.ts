import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeePayroll } from "./home/employee-payroll/employee-payroll";

@Component({
  selector: 'app-root',
  imports: [EmployeePayroll],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('employee-payroll-frontend');
}
