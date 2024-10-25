package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirplanesController {

    public static void addNewAirplane(AirplanesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter AirplaneID: ");
        int airplaneID = scan.nextInt();
        System.out.println("Enter Airplane Name: ");
        String airplaneName = scan.next();
        System.out.println("Enter Airplane Type: ");
        String airplaneType = scan.next();
        System.out.println("Enter Economy Capacity: ");
        int economyCapacity = scan.nextInt();
        System.out.println("Enter Business Capacity: ");
        int businessCapacity = scan.nextInt();

        Airplane airplane = new Airplane();
        airplane.setAirplaneID(airplaneID);
        airplane.setAirplaneName(airplaneName);
        airplane.setAirplaneType(airplaneType);
        airplane.setEconomyCapacity(economyCapacity);
        airplane.setBusinessCapacity(businessCapacity);

        db.addAirplane(airplane);
        System.out.println("Airplane Added Successfully");
    }

    public static void editAirplane(AirplanesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Airplane ID: ");
        int airplaneID = scan.nextInt();
        Airplane airplane = db.getAirplane(airplaneID);

        if (airplane == null) {
            System.out.println("Airplane not found.");
            return;
        }

        System.out.println("Enter Airplane Name: ");
        String airplaneName = scan.next();
        if (airplaneName.equals("-1")) airplaneName = airplane.getAirplaneName();
        System.out.println("Enter Airplane Type: ");
        String airplaneType = scan.next();
        if (airplaneType.equals("-1")) airplaneType = airplane.getAirplaneType();
        System.out.println("Enter Economy Capacity: ");
        int economyCapacity = scan.nextInt();
        if (economyCapacity == -1) economyCapacity = airplane.getEconomyCapacity();
        System.out.println("Enter Business Capacity: ");
        int businessCapacity = scan.nextInt();
        if (businessCapacity == -1) businessCapacity = airplane.getBusinessCapacity();

        airplane.setAirplaneName(airplaneName);
        airplane.setAirplaneType(airplaneType);
        airplane.setEconomyCapacity(economyCapacity);
        airplane.setBusinessCapacity(businessCapacity);
        db.editAirplane(airplane);
        System.out.println("Airplane Edited Successfully");
    }

    public static void printAllAirplanes(AirplanesDatabase db) throws SQLException {
        ArrayList<Airplane> airplanes = db.getAllAirplanes();
        System.out.println("\n---------------------------------");
        for (Airplane airplane : airplanes) {
            airplane.printAirplane();
            System.out.println();
        }
        System.out.println("---------------------------------\n");
    }

    public static void deleteAirplane(AirplanesDatabase db, Scanner scan) throws SQLException {
        System.out.println("Enter Airplane ID: ");
        int airplaneID = scan.nextInt();
        Airplane airplane = db.getAirplane(airplaneID);
        if (airplane == null) {
            System.out.println("Airplane not found.");
            return;
        }
        db.deleteAirplane(airplane);
        System.out.println("Airplane Deleted Successfully");
    }

    public static Airplane getPlaneByID(Database db, int planeID) {
        return null;
    }
}
