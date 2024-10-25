package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class EmployeesDatabase {
    private  String url =  "jdbc:mysql://localhost/airline management system";
    private String user = "abdulrahmanhamdi";
    private String password = "Aa1453Aa$$";
    private Statement statement;
    private Connection connection;

    public EmployeesDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public void addEmployee(Employee employee) throws SQLException {
        String insert = "INSERT INTO `employees`(`employeeID`, `firstName`, `lastName`, `phoneNumber`, `email`, `position`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.executeUpdate();
        }
    }

    public Employee getEmployee(int employeeID) throws SQLException {
        String get = "SELECT `employeeID`, `firstName`, `lastName`, `phoneNumber`, `email`, `position`, `salary` FROM `employees` WHERE `employeeID` = " + employeeID;
        ResultSet resultSet = statement.executeQuery(get);
        if (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeID(resultSet.getInt("employeeID"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setPhoneNumber(resultSet.getString("phoneNumber"));
            employee.setEmail(resultSet.getString("email"));
            employee.setPosition(resultSet.getString("position"));
            employee.setSalary(resultSet.getDouble("salary"));
            return employee;
        }
        return null;
    }

    public void editEmployee(Employee employee) throws SQLException {
        String update = "UPDATE `employees` SET `firstName` = ?, `lastName` = ?, `phoneNumber` = ?, `email` = ?, `position` = ?, `salary` = ? WHERE `employeeID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPhoneNumber());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getEmployeeID());
            preparedStatement.executeUpdate();
        }
    }

    public Employee getEmployee(String firstName, String lastName) throws SQLException {
        String get = "SELECT `employeeID`, `firstName`, `lastName`, `phoneNumber`, `email`, `position`, `salary` FROM `employees` WHERE `firstName` = ? AND `lastName` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getInt("employeeID"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException {
        String get = "SELECT * FROM `employees`;";
        ResultSet resultSet = statement.executeQuery(get);
        ArrayList<Employee> employees = new ArrayList<>();

        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeID(resultSet.getInt("employeeID"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setPhoneNumber(resultSet.getString("phoneNumber"));
            employee.setEmail(resultSet.getString("email"));
            employee.setPosition(resultSet.getString("position"));
            employee.setSalary(resultSet.getDouble("salary"));
            employees.add(employee);
        }
        return employees;
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        String delete = "DELETE FROM `employees` WHERE `employeeID` = " + employee.getEmployeeID() + ";";
        statement.execute(delete);
    }
}
