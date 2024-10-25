package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class AirportDatabase {
    private String url = "jdbc:mysql://localhost/airline management system";
    private String user = "abdulrahmanhamdi";
    private String password = "Aa1453Aa$$";
    private Statement statement;
    private Connection connection;

    public AirportDatabase() throws SQLException {
        connection = DriverManager.getConnection(url ,user,password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
    }

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
        String get = "SELECT `airportID`, `airportName`, `city` FROM `airports` WHERE `airportID` = " + airportID;
        ResultSet resultSet = statement.executeQuery(get);
        if (resultSet.next()) {
            Airport airport = new Airport();
            airport.setAirportID(resultSet.getInt("airportID"));
            airport.setAirportName(resultSet.getString("airportName"));
            airport.setCity(resultSet.getString("city"));
            return airport;
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

    public ArrayList<Airport> getAllAirports() throws SQLException {
        String get = "SELECT * FROM `airports`;";
        ResultSet resultSet = statement.executeQuery(get);
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

    public void deleteAirport(Airport airport) throws SQLException {
        String delete = "DELETE FROM `airports` WHERE `airportID` = " + airport.getAirportID() + ";";
        statement.execute(delete);
    }
}
