package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {
    public static void AddNewEmployee(EmployeesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter EmployeeID: ");
        int employeeID = scan.nextInt();
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        System.out.println("Enter Phone number: ");
        String phoneNumber = scan.next();
        System.out.println("Enter Email: ");
        String email = scan.next();
        System.out.println("Enter Position: ");
        String position = scan.next();
        System.out.println("Enter Salary: ");
        double salary = scan.nextDouble();

        Employee employee = new Employee();
        employee.setEmployeeID(employeeID);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        employee.setPosition(position);
        employee.setSalary(salary);
        db.addEmployee(employee);
        System.out.println("Employee Added Successfully");
    }


    public static void editEmployee(EmployeesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Employee ID: ");
        int employeeID = scan.nextInt();
        Employee employee;
        if (employeeID == -1) {
            employee = getEmployeeByName(db, scan);
        } else {
            employee = db.getEmployee(employeeID);
        }

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        if (firstName.equals("-1")) firstName = employee.getFirstName();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        if (lastName.equals("-1")) lastName = employee.getLastName();
        System.out.println("Enter Phone number: ");
        String phoneNumber = scan.next();
        if (phoneNumber.equals("-1")) phoneNumber = employee.getPhoneNumber();
        System.out.println("Enter Email: ");
        String email = scan.next();
        if (email.equals("-1")) email = employee.getEmail();
        System.out.println("Enter Position: ");
        String position = scan.next();
        if (position.equals("-1")) position = employee.getPosition();
        System.out.println("Enter Salary: ");
        double salary = scan.nextDouble();
        if (salary == -1) salary = employee.getSalary();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        employee.setPosition(position);
        employee.setSalary(salary);
        db.editEmployee(employee);
        System.out.println("Employee Edited Successfully");
    }
    public static void findEmployeeByName(EmployeesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        Employee employee = db.getEmployee(firstName, lastName);
        employee.printEmployee();
    }

    public static Employee getEmployeeByName(EmployeesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        Employee employee = db.getEmployee(firstName, lastName);
        return employee;
    }

    public static void printAllEmployees(EmployeesDatabase db) throws SQLException {
        ArrayList<Employee> employees = db.getAllEmployees();
        System.out.println("\n---------------------------------");
        for (Employee employee : employees) {
            employee.printEmployee();
            System.out.println();
        }
        System.out.println("---------------------------------\n");
    }

    public static void deleteEmployee(EmployeesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Employee ID: ");
        int employeeID = scan.nextInt();
        Employee employee;
        if (employeeID == -1) {
            employee = getEmployeeByName(db, scan);
        } else {
            employee = db.getEmployee(employeeID);
        }
        db.deleteEmployee(employee);
        System.out.println("Employee Deleted Successfully");
    }
}
