package model;

/*
 * INHERITANCE
 * METHOD OVERRIDING
 * POLYMORPHISM
 * INTERFACE IMPLEMENTATION
 */
public class PermanentEmployee extends Employee implements BonusCalculator {

    public PermanentEmployee(int empId,
                             String name,
                             double basicSalary) {

        super(empId, name, basicSalary);
    }

    @Override
    public double calculateSalary() {

        double hra = basicSalary * 0.20;
        double da  = basicSalary * 0.10;

        return basicSalary + hra + da;
    }

    @Override
    public double calculateBonus() {

        return basicSalary * 0.15;
    }
}
