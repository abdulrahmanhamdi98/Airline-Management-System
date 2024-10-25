package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        EmployeesDatabase employeesDb;
        Database passengersDb;
        AirplanesDatabase airplanesDb;
        AirportDatabase airportsDb;

        try {
            employeesDb = new EmployeesDatabase();
            passengersDb = new Database();
            airplanesDb = new AirplanesDatabase();
            airportsDb = new AirportDatabase();
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("1. Add new employee");
            System.out.println("2. Print all employees");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Add new passenger");
            System.out.println("6. Print all passengers");
            System.out.println("7. Edit passenger");
            System.out.println("8. Delete passenger");
            System.out.println("9. Add new plane");
            System.out.println("10. Print all planes");
            System.out.println("11. Edit plane");
            System.out.println("12. Delete plane");
            System.out.println("13. Add new airport");
            System.out.println("14. Print all airports");
            System.out.println("15. Edit airport");
            System.out.println("16. Delete airport");
            System.out.println("0. Exit");

            int choice = scan.nextInt();

            try {
                switch (choice) {
                    case 1:
                        EmployeesController.AddNewEmployee(employeesDb, scan);
                        break;
                    case 2:
                        EmployeesController.printAllEmployees(employeesDb);
                        break;
                    case 3:
                        EmployeesController.editEmployee(employeesDb, scan);
                        break;
                    case 4:
                        EmployeesController.deleteEmployee(employeesDb, scan);
                        break;
                    case 5:
                        PassengersController.AddNewPassenger(passengersDb, scan);
                        break;
                    case 6:
                        PassengersController.printAllPassengers(passengersDb);
                        break;
                    case 7:
                        PassengersController.editPassenger(passengersDb, scan);
                        break;
                    case 8:
                        PassengersController.deletePassenger(passengersDb, scan);
                        break;
                    case 9:
                        AirplanesController.addNewAirplane(airplanesDb, scan);
                        break;
                    case 10:
                        AirplanesController.printAllAirplanes(airplanesDb);
                        break;
                    case 11:
                        AirplanesController.editAirplane(airplanesDb, scan);
                        break;
                    case 12:
                        AirplanesController.deleteAirplane(airplanesDb, scan);
                        break;
                    case 13:
                        AirportsController.addNewAirport(airportsDb, scan);
                        break;
                    case 14:
                        AirportsController.printAllAirports(airportsDb);
                        break;
                    case 15:
                        AirportsController.editAirport(airportsDb, scan);
                        break;
                    case 16:
                        AirportsController.deleteAirport(airportsDb, scan);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scan.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
