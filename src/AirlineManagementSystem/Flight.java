package AirlineManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    private int flightID;
    private Airplane airplane;
    private Airport airport;
    private Airport destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean delayed;
    private int bookedEconomy;
    private int bookedBusiness;
    private Employee [] stuff;
    private Passenger [] passenger;
    private double price;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");

    public Flight() {
        delayed = false;
        bookedEconomy = 0;
        bookedBusiness = 0;
        stuff = new Employee[10];
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
        int totalCapacity = airplane.getBusinessCapacity()+airplane.getEconomyCapacity();
        passenger = new Passenger[totalCapacity];
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isDelayed() {
        return delayed;
    }
    public void delay() {
        delayed = true;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }

    public int getBookedEconomy() {
        return bookedEconomy;
    }

    public void setBookedEconomy(int bookedEconomy) {
        this.bookedEconomy = bookedEconomy;
    }

    public int getBookedBusiness() {
        return bookedBusiness;
    }

    public void setBookedBusiness(int bookedBusiness) {
        this.bookedBusiness = bookedBusiness;
    }

    public Employee[] getStuff() {
        return stuff;
    }

    public void setStuff(Employee[] stuff) {
        this.stuff = stuff;
    }

    public Passenger[] getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger[] passenger) {
        this.passenger = passenger;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}
