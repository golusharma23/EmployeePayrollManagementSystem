package util;

import model.Employee;
import java.io.*;
import java.util.List;

/*
 * FILE HANDLING
 * SERIALIZATION
 */
public class FileManager {

    public static void saveEmployees(
            List<Employee> employees,
            String fileName) throws IOException {

        ObjectOutputStream oos =
                new ObjectOutputStream(
                        new FileOutputStream(fileName));

        oos.writeObject(employees);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> loadEmployees(
            String fileName)
            throws IOException, ClassNotFoundException {

        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream(fileName));

        List<Employee> employees =
                (List<Employee>) ois.readObject();

        ois.close();

        return employees;
    }
}
