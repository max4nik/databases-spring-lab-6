package ua.lviv.iot.flight.dto;

public class AirportDto {
  private Integer id;
  private String name;
  private Integer amountOfWorkers;
  private String city;
  private Integer flightsFromAirportCounter;
  private Integer flightsToAirportCounter;

  public AirportDto(Integer id, String name, Integer amountOfWorkers, String city, Integer flightsFromAirportCounter, Integer flightsToAirportCounter) {
    this.id = id;
    this.name = name;
    this.amountOfWorkers = amountOfWorkers;
    this.city = city;
    this.flightsFromAirportCounter = flightsFromAirportCounter;
    this.flightsToAirportCounter = flightsToAirportCounter;
  }

  public AirportDto() {

  }

  public Integer getFlightsFromAirportCounter() {
    return flightsFromAirportCounter;
  }

  public void setFlightsFromAirportCounter(Integer flightsFromAirportCounter) {
    this.flightsFromAirportCounter = flightsFromAirportCounter;
  }

  public Integer getFlightsToAirportCounter() {
    return flightsToAirportCounter;
  }

  public void setFlightsToAirportCounter(Integer flightsToAirportCounter) {
    this.flightsToAirportCounter = flightsToAirportCounter;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAmountOfWorkers() {
    return amountOfWorkers;
  }

  public void setAmountOfWorkers(Integer amountOfWorkers) {
    this.amountOfWorkers = amountOfWorkers;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


}
