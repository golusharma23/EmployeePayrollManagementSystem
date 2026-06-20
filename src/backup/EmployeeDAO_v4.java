package database;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * JDBC CRUD
 * INSERT + READ + SEARCH
 */
public class EmployeeDAO {

    // CREATE
    public void insertEmployee(Employee employee) {

        String sql =
                "INSERT INTO employee " +
                "(emp_id, emp_name, basic_salary, final_salary) " +
                "VALUES (?, ?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getName());
            ps.setDouble(3, employee.getBasicSalary());
            ps.setDouble(4, employee.calculateSalary());

            ps.executeUpdate();

            System.out.println(
                    "Employee Saved Successfully!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // READ
    public void getAllEmployees() {

        String sql = "SELECT * FROM employee";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println();
            System.out.println(
                    "===== EMPLOYEE RECORDS ====="
            );

            while(rs.next()) {

                System.out.println(
                        rs.getInt("emp_id")
                        + " | "
                        + rs.getString("emp_name")
                        + " | "
                        + rs.getDouble("basic_salary")
                        + " | "
                        + rs.getDouble("final_salary")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // SEARCH
    public void searchEmployee(int empId) {

        String sql =
                "SELECT * FROM employee WHERE emp_id = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, empId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                System.out.println();
                System.out.println(
                        "===== EMPLOYEE FOUND ====="
                );

                System.out.println(
                        "ID : " +
                        rs.getInt("emp_id")
                );

                System.out.println(
                        "Name : " +
                        rs.getString("emp_name")
                );

                System.out.println(
                        "Basic Salary : " +
                        rs.getDouble("basic_salary")
                );

                System.out.println(
                        "Final Salary : " +
                        rs.getDouble("final_salary")
                );

            } else {

                System.out.println(
                        "Employee Not Found!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
