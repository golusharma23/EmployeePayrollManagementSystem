package model;

import java.io.Serializable;

/*
 * ABSTRACT CLASS
 * Demonstrates:
 * - Abstraction
 * - Encapsulation
 * - Serialization
 */
public abstract class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    // Encapsulated Fields
    protected int empId;
    protected String name;
    protected double basicSalary;

    // Constructor
    public Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getters
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Setter
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    // Abstract Method (Abstraction)
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee ID: " + empId +
               ", Name: " + name +
               ", Basic Salary: " + basicSalary;
    }
}
