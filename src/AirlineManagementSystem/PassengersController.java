package AirlineManagementSystem;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengersController {

    public static void AddNewPassenger(Database db, Scanner scan) throws SQLException {
        System.out.println("Enter Passenger ID: ");
        int passengerID = scan.nextInt();
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        System.out.println("Enter Phone number: ");
        String phoneNumber = scan.next();
        System.out.println("Enter Email: ");
        String email = scan.next();

        Passenger passenger = new Passenger();
        passenger.setPassengerID(passengerID);
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setEmail(email);

        db.addPassenger(passenger);
        System.out.println("Passenger Added Successfully");
    }

    public static void editPassenger(PassengersDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Passenger ID: ");
        int passengerID = scan.nextInt();
        Passenger passenger;
        if (passengerID == -1) {
            passenger = getPassengerByName(db, scan);
        } else {
            passenger = db.getPassenger(passengerID);
        }

        if (passenger == null) {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        if (firstName.equals("-1")) firstName = passenger.getFirstName();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        if (lastName.equals("-1")) lastName = passenger.getLastName();
        System.out.println("Enter Phone number: ");
        String phoneNumber = scan.next();
        if (phoneNumber.equals("-1")) phoneNumber = passenger.getPhoneNumber();
        System.out.println("Enter Email: ");
        String email = scan.next();
        if (email.equals("-1")) email = passenger.getEmail();

        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setEmail(email);
        db.editPassenger(passenger);
        System.out.println("Passenger Edited Successfully");
    }

    public static void findPassengerByName(Database db, Scanner scan) throws SQLException {
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        Passenger passenger = db.getPassenger(firstName, lastName);
        passenger.printPassenger();
    }
    public static Passenger getPassengerByName(PassengersDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter First Name: ");
        String firstName = scan.next();
        System.out.println("Enter Last Name: ");
        String lastName = scan.next();
        Passenger passenger = db.getPassenger(firstName, lastName);
        return passenger;
    }
    public static void printAllPassengers(PassengersDatabase db) throws SQLException {
        ArrayList<Passenger> passengers = db.getAllPassengers();
        System.out.println("\n---------------------------------");
        for (Passenger passenger : passengers) {
            passenger.printPassenger();
            System.out.println();
        }
        System.out.println("---------------------------------\n");
    }
    public static void deletePassenger(PassengersDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Passenger ID: ");
        int passengerID = scan.nextInt();
        Passenger passenger;
        if (passengerID == -1) {
            passenger = getPassengerByName(db, scan);
        }else {
            passenger = db.getPassenger(passengerID);
        }
        db.deletePassenger(passenger);
        System.out.println("Passenger deleted Successfully");
    }

}

