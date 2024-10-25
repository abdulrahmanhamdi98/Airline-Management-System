package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private  String url =  "jdbc:mysql://localhost/airline management system";
    private String user = "abdulrahmanhamdi";
    private String password = "Aa1453Aa$$";
    private Connection connection;

    public Database() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    // **Passenger Operations**
    public void addPassenger(Passenger passenger) throws SQLException {
        String insert = "INSERT INTO `passengers`(`passengerID`, `FirstName`, `LastName`, `phoneNumber`, `email`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, passenger.getPassengerID());
            preparedStatement.setString(2, passenger.getFirstName());
            preparedStatement.setString(3, passenger.getLastName());
            preparedStatement.setString(4, passenger.getPhoneNumber());
            preparedStatement.setString(5, passenger.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    public Passenger getPassenger(int passengerID) throws SQLException {
        String get = "SELECT `passengerID`, `FirstName`, `LastName`, `phoneNumber`, `email` FROM `passengers` WHERE `passengerID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setInt(1, passengerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerID(resultSet.getInt("passengerID"));
                passenger.setFirstName(resultSet.getString("FirstName"));
                passenger.setLastName(resultSet.getString("LastName"));
                passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
                passenger.setEmail(resultSet.getString("email"));
                return passenger;
            }
        }
        return null;
    }
    public Passenger getPassenger(String firstName, String lastName) throws SQLException {
        String get = "SELECT `passengerID`, `FirstName`, `LastName`, `phoneNumber`, `email` FROM `passengers` WHERE `FirstName` = ? AND `LastName` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerID(resultSet.getInt("passengerID"));
                passenger.setFirstName(resultSet.getString("FirstName"));
                passenger.setLastName(resultSet.getString("LastName"));
                passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
                passenger.setEmail(resultSet.getString("email"));
                return passenger;
            }
        }
        return null;
    }

    public void editPassenger(Passenger passenger) throws SQLException {
        String update = "UPDATE `passengers` SET `FirstName` = ?, `LastName` = ?, `phoneNumber` = ?, `email` = ? WHERE `passengerID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, passenger.getFirstName());
            preparedStatement.setString(2, passenger.getLastName());
            preparedStatement.setString(3, passenger.getPhoneNumber());
            preparedStatement.setString(4, passenger.getEmail());
            preparedStatement.setInt(5, passenger.getPassengerID());
            preparedStatement.executeUpdate();
        }
    }

    public void deletePassenger(int passengerID) throws SQLException {
        String delete = "DELETE FROM `passengers` WHERE `passengerID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, passengerID);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Passenger> getAllPassengers() throws SQLException {
        String get = "SELECT * FROM `passengers`";
        ResultSet resultSet = connection.createStatement().executeQuery(get);
        ArrayList<Passenger> passengers = new ArrayList<>();
        while (resultSet.next()) {
            Passenger passenger = new Passenger();
            passenger.setPassengerID(resultSet.getInt("passengerID"));
            passenger.setFirstName(resultSet.getString("FirstName"));
            passenger.setLastName(resultSet.getString("LastName"));
            passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
            passenger.setEmail(resultSet.getString("email"));
            passengers.add(passenger);
        }
        return passengers;
    }

    // **Airplane Operations**
    public void addAirplane(Airplane airplane) throws SQLException {
        String insert = "INSERT INTO `airplanes`(`airplaneID`, `airplaneName`, `airplaneType`, `economyCapacity`, `businessCapacity`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, airplane.getAirplaneID());
            preparedStatement.setString(2, airplane.getAirplaneName());
            preparedStatement.setString(3, airplane.getAirplaneType());
            preparedStatement.setInt(4, airplane.getEconomyCapacity());
            preparedStatement.setInt(5, airplane.getBusinessCapacity());
            preparedStatement.executeUpdate();
        }
    }

    public Airplane getAirplane(int airplaneID) throws SQLException {
        String get = "SELECT * FROM `airplanes` WHERE `airplaneID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setInt(1, airplaneID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setAirplaneID(resultSet.getInt("airplaneID"));
                airplane.setAirplaneName(resultSet.getString("airplaneName"));
                airplane.setAirplaneType(resultSet.getString("airplaneType"));
                airplane.setEconomyCapacity(resultSet.getInt("economyCapacity"));
                airplane.setBusinessCapacity(resultSet.getInt("businessCapacity"));
                return airplane;
            }
        }
        return null;
    }

    public void editAirplane(Airplane airplane) throws SQLException {
        String update = "UPDATE `airplanes` SET `airplaneName` = ?, `airplaneType` = ?, `economyCapacity` = ?, `businessCapacity` = ? WHERE `airplaneID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, airplane.getAirplaneName());
            preparedStatement.setString(2, airplane.getAirplaneType());
            preparedStatement.setInt(3, airplane.getEconomyCapacity());
            preparedStatement.setInt(4, airplane.getBusinessCapacity());
            preparedStatement.setInt(5, airplane.getAirplaneID());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteAirplane(int airplaneID) throws SQLException {
        String delete = "DELETE FROM `airplanes` WHERE `airplaneID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, airplaneID);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Airplane> getAllAirplanes() throws SQLException {
        String get = "SELECT * FROM `airplanes`";
        ResultSet resultSet = connection.createStatement().executeQuery(get);
        ArrayList<Airplane> airplanes = new ArrayList<>();
        while (resultSet.next()) {
            Airplane airplane = new Airplane();
            airplane.setAirplaneID(resultSet.getInt("airplaneID"));
            airplane.setAirplaneName(resultSet.getString("airplaneName"));
            airplane.setAirplaneType(resultSet.getString("airplaneType"));
            airplane.setEconomyCapacity(resultSet.getInt("economyCapacity"));
            airplane.setBusinessCapacity(resultSet.getInt("businessCapacity"));
            airplanes.add(airplane);
        }
        return airplanes;
    }

    // **Airport Operations**
    public void addAirport(Airport airport) throws SQLException {
        String insert = "INSERT INTO `airports`(`airportID`, `airportName`, `city`) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, airport.getAirportID());
            preparedStatement.setString(2, airport.getAirportName());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.executeUpdate();
        }
    }

    public Airport getAirport(int airportID) throws SQLException {
        String get = "SELECT * FROM `airports` WHERE `airportID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setInt(1, airportID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Airport airport = new Airport();
                airport.setAirportID(resultSet.getInt("airportID"));
                airport.setAirportName(resultSet.getString("airportName"));
                airport.setCity(resultSet.getString("city"));
                return airport;
            }
        }
        return null;
    }

    public void editAirport(Airport airport) throws SQLException {
        String update = "UPDATE `airports` SET `airportName` = ?, `city` = ? WHERE `airportID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, airport.getAirportName());
            preparedStatement.setString(2, airport.getCity());
            preparedStatement.setInt(3, airport.getAirportID());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteAirport(int airportID) throws SQLException {
        String delete = "DELETE FROM `airports` WHERE `airportID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, airportID);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Airport> getAllAirports() throws SQLException {
        String get = "SELECT * FROM `airports`";
        ResultSet resultSet = connection.createStatement().executeQuery(get);
        ArrayList<Airport> airports = new ArrayList<>();
        while (resultSet.next()) {
            Airport airport = new Airport();
            airport.setAirportID(resultSet.getInt("airportID"));
            airport.setAirportName(resultSet.getString("airportName"));
            airport.setCity(resultSet.getString("city"));
            airports.add(airport);
        }
        return airports;
    }

    // **Flight Operations**
   /* public void addFlight(Flight flight) throws SQLException {
        String insert = "INSERT INTO `flights`(`flightID`, `flightNumber`, `departureAirportID`, `arrivalAirportID`, `departureTime`, `arrivalTime`, `airplaneID`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, flight.getFlightID());
            preparedStatement.setString(2, flight.getFlightNumber());
            preparedStatement.setInt(3, flight.getDepartureAirportID());
            preparedStatement.setInt(4, flight.getArrivalAirportID());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(flight.getDepartureTime()));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(flight.getArrivalTime()));
            preparedStatement.setInt(7, flight.getAirplaneID());
            preparedStatement.executeUpdate();
        }
    }

    public Flight getFlight(int flightID) throws SQLException {
        String get = "SELECT * FROM `flights` WHERE `flightID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(get)) {
            preparedStatement.setInt(1, flightID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightID(resultSet.getInt("flightID"));
                flight.setFlightNumber(resultSet.getString("flightNumber"));
                flight.setDepartureAirportID(resultSet.getInt("departureAirportID"));
                flight.setArrivalAirportID(resultSet.getInt("arrivalAirportID"));
                flight.setDepartureTime(resultSet.getTimestamp("departureTime").toLocalDateTime());
                flight.setArrivalTime(resultSet.getTimestamp("arrivalTime").toLocalDateTime());
                flight.setAirplaneID(resultSet.getInt("airplaneID"));
                return flight;
            }
        }
        return null;
    }

    public void editFlight(Flight flight) throws SQLException {
        String update = "UPDATE `flights` SET `flightNumber` = ?, `departureAirportID` = ?, `arrivalAirportID` = ?, `departureTime` = ?, `arrivalTime` = ?, `airplaneID` = ? WHERE `flightID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setInt(2, flight.getDepartureAirportID());
            preparedStatement.setInt(3, flight.getArrivalAirportID());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(flight.getDepartureTime()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(flight.getArrivalTime()));
            preparedStatement.setInt(6, flight.getAirplaneID());
            preparedStatement.setInt(7, flight.getFlightID());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteFlight(int flightID) throws SQLException {
        String delete = "DELETE FROM `flights` WHERE `flightID` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, flightID);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Flight> getAllFlights() throws SQLException {
        String get = "SELECT * FROM `flights`";
        ResultSet resultSet = connection.createStatement().executeQuery(get);
        ArrayList<Flight> flights = new ArrayList<>();
        while (resultSet.next()) {
            Flight flight = new Flight();
            flight.setFlightID(resultSet.getInt("flightID"));
            flight.setFlightNumber(resultSet.getString("flightNumber"));
            flight.setDepartureAirportID(resultSet.getInt("departureAirportID"));
            flight.setArrivalAirportID(resultSet.getInt("arrivalAirportID"));
            flight.setDepartureTime(resultSet.getTimestamp("departureTime").toLocalDateTime());
            flight.setArrivalTime(resultSet.getTimestamp("arrivalTime").toLocalDateTime());
            flight.setAirplaneID(resultSet.getInt("airplaneID"));
            flights.add(flight);
        }
        return flights;
    }*/

    // Close the connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
