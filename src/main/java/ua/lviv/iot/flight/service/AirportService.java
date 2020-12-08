package ua.lviv.iot.flight.service;

import org.springframework.stereotype.Service;
import ua.lviv.iot.flight.domain.Airport;
import ua.lviv.iot.flight.repository.AirportRepository;

import java.util.List;

@Service
public class AirportService implements AbstractService<Airport, Integer> {

  private final AirportRepository airportRepository;

  public AirportService(AirportRepository airportRepository) {
    this.airportRepository = airportRepository;
  }

  @Override
  public List<Airport> getAll() {
    return airportRepository.findAll();
  }

  @Override
  public Airport getById(Integer id) {
    return airportRepository.getOne(id);
  }

  @Override
  public Airport create(Airport airport) {
    return airportRepository.save(airport);
  }

  @Override
  public Airport update(Integer id, Airport airport) {
    if (airportRepository.findById(id).isPresent()) {
      return airportRepository.save(airport);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (airportRepository.findById(id).isPresent()) {
      airportRepository.deleteById(id);
    }
  }
}
