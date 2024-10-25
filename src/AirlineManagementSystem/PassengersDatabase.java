package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class PassengersDatabase {
    private  String url =  "jdbc:mysql://localhost/airline management system";
    private  String user = "abdulrahmanhamdi";
    private  String password = "Aa1453Aa$$";
    private Statement statement;
    private Connection connection;

    public PassengersDatabase() throws SQLException {
        connection = DriverManager.getConnection(url ,user,password);
         statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY);
    }
    public void AddPassenger(Passenger passenger) throws SQLException {
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
        String get = "SELECT `passengerID`, `FirstName`, `LastName`, `phoneNumber`, `email` FROM `passengers` WHERE `passengerID` = " + passengerID;
        ResultSet resultSet = statement.executeQuery(get);
        if (resultSet.next()) {
            Passenger passenger = new Passenger();
            passenger.setPassengerID(resultSet.getInt("passengerID"));
            passenger.setFirstName(resultSet.getString("FirstName"));
            passenger.setLastName(resultSet.getString("LastName"));
            passenger.setEmail(resultSet.getString("email"));
            passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
            return passenger;
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



    public ArrayList<Passenger> getAllPassengers() throws SQLException{
        String get = "SELECT * FROM `passengers`;";
        ResultSet resultSet = statement.executeQuery(get);
        ArrayList<Passenger> passengers = new ArrayList<>();

        while (resultSet.next()) {
            Passenger passenger = new Passenger();
            passenger.setPassengerID(Integer.parseInt(resultSet.getString("PassengerID")));
            passenger.setFirstName(resultSet.getString("FirstName"));
            passenger.setLastName(resultSet.getString("LastName"));
            passenger.setEmail(resultSet.getString("Email"));
            passenger.setPhoneNumber(resultSet.getString("PhoneNumber"));
            passengers.add(passenger);
        }
        return passengers;
    }
    public void deletePassenger(Passenger passenger) throws SQLException {
        String delete = "DELETE FROM `passengers` WHERE `passengerID`="+passenger.getPassengerID()+";";
        statement.execute(delete);

    }
}
