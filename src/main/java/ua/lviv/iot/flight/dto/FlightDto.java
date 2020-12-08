package ua.lviv.iot.flight.dto;

public class FlightDto {
  private Integer id;
  private String fromAirportName;
  private String toAirportName;
  private String departureTime;
  private String arrivalTime;
  private String pilotName;
  private String aircraftModelName;
  private Boolean isAvailable;
  private String aviacompanyName;
  private Integer availableSeats;

  public FlightDto(Integer id, String fromAirportName, String toAirportName, String departureTime, String arrivalTime, String pilotName, String aircraftModelName, Boolean isAvailable, String aviacompanyName, Integer availableSeats) {
    this.id = id;
    this.fromAirportName = fromAirportName;
    this.toAirportName = toAirportName;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.pilotName = pilotName;
    this.aircraftModelName = aircraftModelName;
    this.isAvailable = isAvailable;
    this.aviacompanyName = aviacompanyName;
    this.availableSeats = availableSeats;
  }

  public FlightDto() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFromAirportName() {
    return fromAirportName;
  }

  public void setFromAirportName(String fromAirportName) {
    this.fromAirportName = fromAirportName;
  }

  public String getToAirportName() {
    return toAirportName;
  }

  public void setToAirportName(String toAirportName) {
    this.toAirportName = toAirportName;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getPilotName() {
    return pilotName;
  }

  public void setPilotName(String pilotName) {
    this.pilotName = pilotName;
  }

  public String getAircraftModelName() {
    return aircraftModelName;
  }

  public void setAircraftModelName(String aircraftModelName) {
    this.aircraftModelName = aircraftModelName;
  }

  public Boolean getAvailable() {
    return isAvailable;
  }

  public void setAvailable(Boolean available) {
    isAvailable = available;
  }

  public String getAviacompanyName() {
    return aviacompanyName;
  }

  public void setAviacompanyName(String aviacompanyName) {
    this.aviacompanyName = aviacompanyName;
  }

  public Integer getAvailableSeats() {
    return availableSeats;
  }

  public void setAvailableSeats(Integer availableSeats) {
    this.availableSeats = availableSeats;
  }


}
