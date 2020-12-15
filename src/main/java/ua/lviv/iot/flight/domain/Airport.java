package ua.lviv.iot.flight.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "airport")
public class Airport {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;
  @Column(name = "amount_of_workers")
  private Integer amountOfWorkers;
  @Column(name = "city")
  private String city;

  @OneToMany(mappedBy = "fromAirport", fetch = FetchType.EAGER)
  private Set<Flight> flightsFromAirport;

  @OneToMany(mappedBy = "toAirport", fetch = FetchType.EAGER)
  private Set<Flight> flightsToAirport;

  public Airport(Integer id, String name, Integer amountOfWorkers, String city, Set<Flight> flightsFromAirport, Set<Flight> flightsToAirport) {
    this.id = id;
    this.name = name;
    this.amountOfWorkers = amountOfWorkers;
    this.city = city;
    this.flightsFromAirport = flightsFromAirport;
    this.flightsToAirport = flightsToAirport;
  }

  public Airport(String name, Integer amountOfWorkers, String city) {
    this(null, name, amountOfWorkers, city, null, null);
  }

  public Airport() {

  }

  public Airport(Integer id, String name, Integer amountOfWorkers, String city) {
    this(id, name, amountOfWorkers, city, null, null);
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

  public Set<Flight> getFlightsFromAirport() {
    return flightsFromAirport;
  }

  public void setFlightsFromAirport(Set<Flight> flights) {
    this.flightsFromAirport = flights;
  }

  public Set<Flight> getFlightsToAirport() {
    return flightsToAirport;
  }

  public void setFlightsToAirport(Set<Flight> flightsToAirport) {
    this.flightsToAirport = flightsToAirport;
  }

  @Override
  public String toString() {
    return "Airport{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", amountOfWorkers=" + amountOfWorkers +
        ", city='" + city + '\'' +
        '}';
  }
}
