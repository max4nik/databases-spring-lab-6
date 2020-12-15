package ua.lviv.iot.flight.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "aviacompany")
public class Aviacompany {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "creation_date")
  private String creationDate;


  @OneToMany(mappedBy = "aviacompany", fetch = FetchType.EAGER)
  private Set<Aircraft> aircrafts;


  @OneToMany(mappedBy = "aviacompany", fetch = FetchType.EAGER)
  private Set<Flight> flights;

  public Aviacompany(Integer id, String name, String creationDate, Set<Aircraft> aircrafts, Set<Flight> flights) {
    this.id = id;
    this.name = name;
    this.creationDate = creationDate;
    this.aircrafts = aircrafts;
    this.flights = flights;
  }


  public Aviacompany(String name, String creationDate) {
    this(null, name, creationDate, null, null);
  }

  public Aviacompany() {

  }

  public Aviacompany(Integer id, String name, String creationDate) {
    this(id, name, creationDate, null, null);
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

  public Set<Aircraft> getAircrafts() {
    return aircrafts;
  }

  public void setAircrafts(Set<Aircraft> aircrafts) {
    this.aircrafts = aircrafts;
  }

  public Set<Flight> getFlights() {
    return flights;
  }

  public void setFlights(Set<Flight> flights) {
    this.flights = flights;
  }

  @Override
  public String toString() {
    return "Aviacompany{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", creationDate='" + creationDate + '\'' +
        '}';
  }
}
