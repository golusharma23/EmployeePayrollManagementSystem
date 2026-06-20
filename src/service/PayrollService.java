package service;

import model.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * STREAM API
 * LAMBDA EXPRESSIONS
 */
public class PayrollService {

    // Lambda Expression
    public void sortEmployeesBySalary(List<Employee> employees) {

        employees.sort(
            (e1, e2) ->
                Double.compare(
                    e1.getBasicSalary(),
                    e2.getBasicSalary()
                )
        );
    }

    // Streams API
    public List<Employee> getHighSalaryEmployees(
            List<Employee> employees,
            double salary) {

        return employees.stream()
                .filter(emp ->
                        emp.getBasicSalary() > salary)
                .collect(Collectors.toList());
    }
}
