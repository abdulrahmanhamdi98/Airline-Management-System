package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportsController {

    public static void addNewAirport(AirportDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Airport ID: ");
        int airportID = scan.nextInt();
        System.out.println("Enter Airport Name: ");
        String airportName = scan.next();
        System.out.println("Enter City: ");
        String city = scan.next();

        Airport airport = new Airport();
        airport.setAirportID(airportID);
        airport.setAirportName(airportName);
        airport.setCity(city);


        db.addAirport(airport);
        System.out.println("Airport Added Successfully");
    }

    public static void editAirport(AirportDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Airport ID: ");
        int airportID = scan.nextInt();
        Airport airport = db.getAirport(airportID);

        if (airport == null) {
            System.out.println("Airport not found.");
            return;
        }

        System.out.println("Enter Airport Name: ");
        String airportName = scan.next();
        if (airportName.equals("-1")) airportName = airport.getAirportName();
        System.out.println("Enter City: ");
        String city = scan.next();
        if (city.equals("-1")) city = airport.getCity();

        airport.setAirportName(airportName);
        airport.setCity(city);
        db.editAirport(airport);
        System.out.println("Airport Edited Successfully");
    }

    public static void printAllAirports(AirportDatabase db) throws SQLException {
        ArrayList<Airport> airports = db.getAllAirports();
        System.out.println("\n---------------------------------");
        System.out.println("id\tcity");
        for (Airport airport : airports) {
            airport.print();
            System.out.println();
        }
        System.out.println("---------------------------------\n");
    }

    public static void deleteAirport(AirportDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Airport ID: ");
        int airportID = scan.nextInt();
        Airport airport = db.getAirport(airportID);
        if (airport == null) {
            System.out.println("Airport not found.");
            return;
        }
        db.deleteAirport(airport);
        System.out.println("Airport Deleted Successfully");
    }
}
