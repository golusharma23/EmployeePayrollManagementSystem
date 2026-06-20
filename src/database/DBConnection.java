package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_db";

    private static final String USER = "root";

    private static final String PASSWORD = "1234";

    public static Connection getConnection() {

        try {

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            return con;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}
