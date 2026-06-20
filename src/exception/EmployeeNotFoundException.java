package exception;

/*
 * CUSTOM EXCEPTION
 */
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
