package threads;

import model.Employee;
import util.FileManager;

import java.util.List;

/*
 * MULTITHREADING
 * AUTO BACKUP THREAD
 */
public class AutoBackupThread extends Thread {

    private List<Employee> employees;

    public AutoBackupThread(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {

        while (true) {

            try {

                FileManager.saveEmployees(
                        employees,
                        "employee_backup.dat"
                );

                System.out.println(
                        "[AUTO BACKUP COMPLETED]"
                );

                Thread.sleep(60000);

            } catch (Exception e) {

                System.out.println(
                        "Backup Error : "
                        + e.getMessage()
                );
            }
        }
    }
}
