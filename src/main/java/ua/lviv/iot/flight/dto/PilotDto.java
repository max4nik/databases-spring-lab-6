package ua.lviv.iot.flight.dto;

public class PilotDto {
  private Integer id;
  private String surName;
  private String name;
  private String position;
  private Integer flightsCounter;

  public PilotDto(Integer id, String surName, String name, String position, Integer flightsCounter) {
    this.id = id;
    this.surName = surName;
    this.name = name;
    this.position = position;
    this.flightsCounter = flightsCounter;
  }

  public PilotDto() {

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

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getFlightsCounter() {
    return flightsCounter;
  }

  public void setFlightsCounter(Integer flightsCounter) {
    this.flightsCounter = flightsCounter;
  }
}
