package ua.lviv.iot.flight.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pilot")
public class Pilot {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "surname")
  private String surName;

  @Column(name = "name")
  private String name;

  @Column(name = "position")
  private String position;


  @OneToMany(mappedBy = "pilot", fetch = FetchType.EAGER)
  private Set<Flight> flights;

  public Pilot(Integer id, String surName, String name, String position, Set<Flight> flights) {
    this.id = id;
    this.name = name;
    this.surName = surName;
    this.position = position;
    this.flights = flights;
  }

  public Pilot(String surName, String name, String position) {
    this(null, name, surName, position, null);
  }

  public Pilot(Integer id, String surName, String name, String position) {
    this(id, name, surName, position, null);
  }

  public Pilot() {

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

  public Set<Flight> getFlights() {
    return flights;
  }

  public void setFlights(Set<Flight> flights) {
    this.flights = flights;
  }

  @Override
  public String toString() {
    return "Pilot{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surName='" + surName + '\'' +
        ", position=" + position +
        '}';
  }


}
