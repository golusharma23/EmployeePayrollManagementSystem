package database;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * JDBC CRUD
 * INSERT OPERATION
 */
public class EmployeeDAO {

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

            ps.setInt(
                    1,
                    employee.getEmpId()
            );

            ps.setString(
                    2,
                    employee.getName()
            );

            ps.setDouble(
                    3,
                    employee.getBasicSalary()
            );

            ps.setDouble(
                    4,
                    employee.calculateSalary()
            );

            ps.executeUpdate();

            System.out.println(
                    "Employee Saved Successfully!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
