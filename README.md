# Employee Payroll Management System

A robust, enterprise-grade Core Java console application built to demonstrate advanced Object-Oriented Programming (OOPs) principles, JDBC database connectivity, Custom Exception Handling, Multi-Threading, and modular architecture.

---

## 🛠️ Tech Stack & Advanced Concepts
* **Core Java:** Abstract Classes, Inheritance, Polymorphism, Method Overriding, and Encapsulation.
* **Database (JDBC):** MySQL connectivity via `DriverManager` for persistent employee management (`payroll_db`).
* **Multi-Threading:** Automated background tasks implemented via custom threads (`AutoBackupThread`).
* **Custom Exceptions:** Domain-specific error handling (`EmployeeNotFoundException`, `InvalidSalaryException`).
* **Modular Architecture:** Clean separation of concerns into dedicated packages (`model`, `service`, `exception`, `threads`, `util`, `database`).

---

## 🏗️ Project Directory Structure

```text
src/
├── model/                  # Core entities & business models
│   ├── Employee.java       # Abstract base class
│   ├── PermanentEmployee.java # Subclass with allowance logic
│   ├── ContractEmployee.java  # Subclass with base salary logic
│   └── BonusCalculator.java   # Bonus computation utility
├── service/                # Business logic handlers
│   ├── EmployeeService.java   # Employee management operations
│   └── PayrollService.java    # Payroll processing engine
├── exception/              # Custom application exceptions
│   ├── EmployeeNotFoundException.java
│   └── InvalidSalaryException.java
├── threads/                # Multithreading modules
│   └── AutoBackupThread.java  # Automated background backups
├── util/                   # Utility & file managers
│   └── FileManager.java       # File read/write helper
├── database/               # Database configurations
│   └── DBConnection.java      # JDBC connection handler
└── Main.java               # Main entry point & interactive console UI
💰 Salary Calculation & Logic Clarification
The system uses Polymorphism and Method Overriding inside the Employee hierarchy. Depending on the employee type selected, the calculateSalary() method behaves differently, explaining why a salary increases for permanent staff versus remaining a fixed base for contract workers.

1. Permanent Employee (Salary Increases via Allowances)
Reason for Increase: Permanent employees are entitled to standard company benefits, specifically HRA (House Rent Allowance - 20%) and DA (Dearness Allowance - 10%) added on top of their base pay.

Code Implementation (PermanentEmployee.java):

Java
class PermanentEmployee extends Employee {
    PermanentEmployee(String name, int empId, double basicSalary) {
        super(name, empId, basicSalary);
    }

    @Override
    double calculateSalary() {
        double hra = basicSalary * 0.20;   // 20% HRA
        double da  = basicSalary * 0.10;   // 10% DA
        return basicSalary + hra + da;    // Final Salary increases by 30% total
    }
}
Example: If Basic Salary is 150,000, HRA (30,000) + DA (15,000) = Total Final Salary becomes 195,000.

2. Contract Employee (Salary Remains Unchanged)
Reason for Clarification (No Increase): Contract employees operate on a fixed-rate agreement without standard corporate allowances (HRA/DA). Therefore, their final payout equals their entered base salary.

Code Implementation (ContractEmployee.java):

Java
class ContractEmployee extends Employee {
    ContractEmployee(String name, int empId, double basicSalary) {
        super(name, empId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary; // No extra allowances added; remains equal to base
    }
}
Example: If Basic Salary is 150,000, Final Salary remains 150,000.

🚀 How to Compile and Run Locally
Database Setup: Ensure your MySQL server is running, create a database named payroll_db, and update your credentials in DBConnection.java.

Navigate & Compile:

PowerShell
cd src
javac Main.java
Execute:

PowerShell
java Main
🖥️ Interactive Console Execution Flow
Plaintext
Choose Employee Type:
1. Permanent Employee
2. Contract Employee
1
Enter Employee Name: Golu Sharma
Enter Employee ID: 109
Enter Basic Salary: 150000

Employee ID: 109
Name: Golu Sharma
Basic Salary: 150000.0
Final Salary: 195000.0   (Includes 30% HRA + DA for Permanent Employees)
<img width="1215" height="285" alt="image" src="https://github.com/user-attachments/assets/2aef6afe-adb5-4d9f-b4b9-db03b75ea2f4" />



👤 Author
Golu Sharma

Backend Developer & ITM Student

GitHub Profile


