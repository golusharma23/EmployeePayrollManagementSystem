import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_db";

    // MySQL Username
    private static final String USER = "root";

    // Apna MySQL password yaha likho
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            return con;

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();

            return null;
        }
    }
}