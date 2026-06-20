import java.util.Scanner;
import java.sql.Connection;


/*
 * ABSTRACT CLASS
 * Shows abstraction and base structure
 */
abstract class Employee {

    // ENCAPSULATION (protected access)
    protected String name;
    protected int empId;
    protected double basicSalary;

    // CONSTRUCTOR
    Employee(String name, int empId, double basicSalary) {
        this.name = name;
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    // Concrete method
    void displayDetails() {
        System.out.println("\nEmployee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }

    // Abstract method
    abstract double calculateSalary();
}

/*
 * INHERITANCE
 */
class PermanentEmployee extends Employee {

    PermanentEmployee(String name, int empId, double basicSalary) {
        super(name, empId, basicSalary);
    }

    // METHOD OVERRIDING
    @Override
    double calculateSalary() {
        double hra = basicSalary * 0.20;   // HRA calculation
        double da  = basicSalary * 0.10;   // DA calculation
        return basicSalary + hra + da;
    }
}

class ContractEmployee extends Employee {

    ContractEmployee(String name, int empId, double basicSalary) {
        super(name, empId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary; // No allowances
    }
}

/*
 * MAIN CLASS
 * Shows primitives, Scanner, loops, condition, exception handling
 */
public class Main {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if(con != null){
            System.out.println("JDBC Connected Successfully!");
        }

        // PRIMITIVE DATA TYPES
        int choice;
        double salary;

        Scanner sc = new Scanner(System.in);

        try {
            // User choice
            System.out.println("Choose Employee Type:");
            System.out.println("1. Permanent Employee");
            System.out.println("2. Contract Employee");

            choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Basic Salary: ");
            salary = sc.nextDouble();

            // POLYMORPHISM
            Employee emp;

            if (choice == 1) {
                emp = new PermanentEmployee(name, id, salary);
            } else {
                emp = new ContractEmployee(name, id, salary);
            }

            emp.displayDetails();
            System.out.println("Final Salary: " + emp.calculateSalary());

        }
        // EXCEPTION HANDLING
        catch (Exception e) {
            System.out.println("Invalid input! Please enter correct data.");
        }
        finally {
            sc.close();
        }
    }
}
