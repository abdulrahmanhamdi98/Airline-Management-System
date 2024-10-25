package AirlineManagementSystem;


public class Airport {

    private String airportName;
    private int airportID;
    private String city;

    public Airport() {
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void print() {
        System.out.println(airportID+"\t"+city);
    }

}
