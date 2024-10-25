package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class AirplanesDatabase {
    private  String url =  "jdbc:mysql://localhost/airline management system";
    private  String user = "abdulrahmanhamdi";
    private  String password = "Aa1453Aa$$";
    private Statement statement;
    private Connection connection;

    public AirplanesDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

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
        String get = "SELECT `airplaneID`, `airplaneName`, `airplaneType`, `economyCapacity`, `businessCapacity` FROM `airplanes` WHERE `airplaneID` = " + airplaneID;
        ResultSet resultSet = statement.executeQuery(get);
        if (resultSet.next()) {
            Airplane airplane = new Airplane();
            airplane.setAirplaneID(resultSet.getInt("airplaneID"));
            airplane.setAirplaneName(resultSet.getString("airplaneName"));
            airplane.setAirplaneType(resultSet.getString("airplaneType"));
            airplane.setEconomyCapacity(resultSet.getInt("economyCapacity"));
            airplane.setBusinessCapacity(resultSet.getInt("businessCapacity"));
            return airplane;
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

    public ArrayList<Airplane> getAllAirplanes() throws SQLException {
        String get = "SELECT * FROM `airplanes`;";
        ResultSet resultSet = statement.executeQuery(get);
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

    public void deleteAirplane(Airplane airplane) throws SQLException {
        String delete = "DELETE FROM `airplanes` WHERE `airplaneID`=" + airplane.getAirplaneID() + ";";
        statement.execute(delete);
    }
}
