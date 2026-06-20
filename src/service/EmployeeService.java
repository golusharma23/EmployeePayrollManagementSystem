package service;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

/*
 * COLLECTIONS
 * GENERICS
 * METHOD OVERLOADING
 */
public class EmployeeService {

    // Generics + Collection
    private List<Employee> employees = new ArrayList<>();

    // Method Overloading - Version 1
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method Overloading - Version 2
    public void addEmployee(List<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}
