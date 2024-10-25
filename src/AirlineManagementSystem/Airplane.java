package AirlineManagementSystem;

public class Airplane {
    private int airplaneID;
    private String airplaneName;
    private String airplaneType;
    private int economyCapacity;
    private int businessCapacity;

    public Airplane() {
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public int getEconomyCapacity() {
        return economyCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        this.economyCapacity = economyCapacity;
    }

    public int getBusinessCapacity() {
        return businessCapacity;
    }

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public void printAirplane() {
        System.out.println("Airplane ID: " + getAirplaneID());
        System.out.println("Airplane Name: " + getAirplaneName());
        System.out.println("Airplane Type: " + getAirplaneType());
        System.out.println("Economy Capacity: " + getEconomyCapacity());
        System.out.println("Business Capacity: " + getBusinessCapacity());
    }
}
