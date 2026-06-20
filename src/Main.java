import model.Employee;
import model.PermanentEmployee;
import model.ContractEmployee;
import database.EmployeeDAO;

import java.util.Scanner;

/*
 * MAIN CLASS
 * Scanner
 * Control Statements
 * Exception Handling
 * JDBC Integration
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("===== EMPLOYEE PAYROLL SYSTEM =====");

            System.out.println("1. Permanent Employee");
            System.out.println("2. Contract Employee");

            System.out.print("Choose Employee Type: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double salary = sc.nextDouble();

            Employee employee;

            if(choice == 1) {

                employee =
                        new PermanentEmployee(
                                id,
                                name,
                                salary
                        );

            } else {

                employee =
                        new ContractEmployee(
                                id,
                                name,
                                salary
                        );
            }

            System.out.println();
            System.out.println("Employee Created Successfully");

            System.out.println(
                    "Final Salary : "
                    + employee.calculateSalary()
            );

            EmployeeDAO dao =
                    new EmployeeDAO();

            dao.insertEmployee(employee);

            dao.getAllEmployees();

            dao.searchEmployee(101);

            dao.updateSalary(101,50000);

            dao.getAllEmployees();

        } catch (Exception e) {

            System.out.println(
                    "Error : "
                    + e.getMessage()
            );
        }

        sc.close();
    }
}
