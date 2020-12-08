package ua.lviv.iot.flight.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "aircraft")
public class Aircraft {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "model_name")
  private String modelName;

  @Column(name = "type")
  private String type;

  @Column(name = "years_in_use")
  private Integer yearsInUse;

  @Column(name = "max_seats")
  private Integer maxSeats;

  @ManyToOne
  @JoinColumn(name = "aviacompany_id", referencedColumnName = "id", nullable = false)
  private Aviacompany aviacompany;

  @OneToMany(mappedBy = "aircraft", fetch = FetchType.EAGER)
  private Set<Flight> flights;

  public Aircraft(Integer id, String modelName, String type, Integer yearsInUse, Integer maxSeats, Aviacompany aviacompany, Set<Flight> flights) {
    this.id = id;
    this.modelName = modelName;
    this.type = type;
    this.yearsInUse = yearsInUse;
    this.maxSeats = maxSeats;
    this.aviacompany = aviacompany;
    this.flights = flights;
  }


  public Aircraft() {

  }

  public Aircraft(Integer id, String modelName, String type, Integer yearsInUse, Integer maxSeats, Aviacompany aviacompany) {
    this(id, modelName, type, yearsInUse, maxSeats, aviacompany, null);
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

  public Aviacompany getAviacompany() {
    return aviacompany;
  }

  public void setAviacompany(Aviacompany aviacompany) {
    this.aviacompany = aviacompany;
  }

  public Set<Flight> getFlights() {
    return flights;
  }

  public void setFlights(Set<Flight> flights) {
    this.flights = flights;
  }

  @Override
  public String toString() {
    return "Aircraft{" +
        "id=" + id +
        ", modelName='" + modelName + '\'' +
        ", type='" + type + '\'' +
        ", yearsInUse=" + yearsInUse +
        ", maxSeats=" + maxSeats +
        ", aviacompany=" + aviacompany +
        '}';
  }
}
