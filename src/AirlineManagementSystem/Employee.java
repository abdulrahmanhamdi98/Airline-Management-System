package AirlineManagementSystem;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String position;
    private double salary;

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public void printEmployee() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Position: " + getPosition());
        System.out.println("Salary: " + getSalary());
    }

}
