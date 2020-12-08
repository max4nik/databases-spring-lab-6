package ua.lviv.iot.flight.domain;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "from_airport", referencedColumnName = "id", nullable = false)
  private Airport fromAirport;

  @ManyToOne
  @JoinColumn(name = "to_airport", referencedColumnName = "id", nullable = false)
  private Airport toAirport;

  @Column(name = "departure_time")
  private String departureTime;

  @Column(name = "arrival_time")
  private String arrivalTime;

  @ManyToOne
  @JoinColumn(name = "pilot_id", referencedColumnName = "id", nullable = false)
  private Pilot pilot;

  @ManyToOne
  @JoinColumn(name = "aircraft_id", referencedColumnName = "id", nullable = false)
  private Aircraft aircraft;

  @Column(name = "is_available")
  private Boolean isAvailable;

  @ManyToOne
  @JoinColumn(name = "aviacompany_id", referencedColumnName = "id", nullable = false)
  private Aviacompany aviacompany;

  @Column(name = "available_seats")
  private Integer availableSeats;

  public Flight(Integer id, Airport fromAirport, Airport toAirport, String departureTime, String arrivalTime, Pilot pilot, Aircraft aircraft, Boolean isAvailable, Aviacompany aviacompany, Integer availableSeats) {
    this.id = id;
    this.fromAirport = fromAirport;
    this.toAirport = toAirport;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.pilot = pilot;
    this.aircraft = aircraft;
    this.isAvailable = isAvailable;
    this.aviacompany = aviacompany;
    this.availableSeats = availableSeats;
  }

  public Flight(Airport fromAirport, Airport toAirport, String departureTime, String arrivalTime, Pilot pilot, Aircraft aircraft, Boolean isAvailable, Aviacompany aviacompany, Integer availableSeats) {
    this(null, fromAirport, toAirport, departureTime, arrivalTime, pilot, aircraft, isAvailable, aviacompany, availableSeats);
  }

  public Flight() {

  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Airport getFromAirport() {
    return fromAirport;
  }

  public void setFromAirport(Airport fromAirport) {
    this.fromAirport = fromAirport;
  }

  public Airport getToAirport() {
    return toAirport;
  }

  public void setToAirport(Airport toAirport) {
    this.toAirport = toAirport;
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

  public Pilot getPilot() {
    return pilot;
  }

  public void setPilot(Pilot pilot) {
    this.pilot = pilot;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public void setAircraft(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public Boolean getAvailable() {
    return isAvailable;
  }

  public void setAvailable(Boolean available) {
    isAvailable = available;
  }

  public Aviacompany getAviacompany() {
    return aviacompany;
  }

  public void setAviacompany(Aviacompany aviacompany) {
    this.aviacompany = aviacompany;
  }

  public Integer getAvailableSeats() {
    return availableSeats;
  }

  public void setAvailableSeats(Integer availableSeats) {
    this.availableSeats = availableSeats;
  }


  @Override
  public String toString() {
    return "Flight{" +
        "id=" + id +
        ", fromAirport=" + fromAirport +
        ", toAirport=" + toAirport +
        ", departureTime='" + departureTime + '\'' +
        ", arrivalTime='" + arrivalTime + '\'' +
        ", pilotId=" + pilot +
        ", aircraftId=" + aircraft +
        ", isAvailable=" + isAvailable +
        ", aviacompanyId=" + aviacompany +
        ", availableSeats=" + availableSeats +
        '}';
  }


}
