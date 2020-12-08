package ua.lviv.iot.flight.dto;

public class AviacompanyDto {
  private Integer id;
  private String name;
  private String creationDate;
  private Integer aircraftsCounter;
  private Integer flightsCounter;

  public AviacompanyDto(Integer id, String name, String creationDate, Integer aircraftsCounter, Integer flightsCounter) {
    this.id = id;
    this.name = name;
    this.creationDate = creationDate;
    this.aircraftsCounter = aircraftsCounter;
    this.flightsCounter = flightsCounter;
  }

  public AviacompanyDto() {

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

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public Integer getAircraftsCounter() {
    return aircraftsCounter;
  }

  public void setAircraftsCounter(Integer aircraftsCounter) {
    this.aircraftsCounter = aircraftsCounter;
  }

  public Integer getFlightsCounter() {
    return flightsCounter;
  }

  public void setFlightsCounter(Integer flightsCounter) {
    this.flightsCounter = flightsCounter;
  }
}
