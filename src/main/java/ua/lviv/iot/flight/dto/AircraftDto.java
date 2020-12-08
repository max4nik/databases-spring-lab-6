package ua.lviv.iot.flight.dto;

public class AircraftDto {
  private Integer id;

  private String modelName;

  private String type;

  private Integer yearsInUse;

  private Integer maxSeats;

  private String aviacompanyName;

  public AircraftDto(Integer id, String modelName, String type, Integer yearsInUse, Integer maxSeats, String aviacompanyName) {
    this.id = id;
    this.modelName = modelName;
    this.type = type;
    this.yearsInUse = yearsInUse;
    this.maxSeats = maxSeats;
    this.aviacompanyName = aviacompanyName;
  }

  public AircraftDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getYearsInUse() {
    return yearsInUse;
  }

  public void setYearsInUse(Integer yearsInUse) {
    this.yearsInUse = yearsInUse;
  }

  public Integer getMaxSeats() {
    return maxSeats;
  }

  public void setMaxSeats(Integer maxSeats) {
    this.maxSeats = maxSeats;
  }

  public String getAviacompanyName() {
    return aviacompanyName;
  }

  public void setAviacompanyName(String aviacompanyName) {
    this.aviacompanyName = aviacompanyName;
  }

}
