import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseUrl = "http://127.0.0.1:64677/api/v1/employees";

  constructor(private http: HttpClient) { }

  // Create (Post a List like your Spring Controller)
  saveEmployees(employees: Employee[]): Observable<Employee[]> {
    return this.http.post<Employee[]>(this.baseUrl, employees);
  }

  // Read All
  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }

  // Update
  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseUrl}/${id}`, employee);
  }

  // Delete
  deleteEmployee(id: number): Observable<string> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
