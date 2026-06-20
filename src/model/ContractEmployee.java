package model;

/*
 * CONTRACT EMPLOYEE
 * Demonstrates:
 * - Inheritance
 * - Method Overriding
 * - Runtime Polymorphism
 */
public class ContractEmployee extends Employee {

    public ContractEmployee(int empId,
                            String name,
                            double basicSalary) {

        super(empId, name, basicSalary);
    }

    @Override
    public double calculateSalary() {

        // Contract employee gets no HRA/DA
        return basicSalary;
    }
}
