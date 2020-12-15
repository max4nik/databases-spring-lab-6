package ua.lviv.iot.flight.service;

import org.springframework.stereotype.Service;
import ua.lviv.iot.flight.domain.Aircraft;
import ua.lviv.iot.flight.repository.AircraftRepository;

import java.util.List;

@Service
public class AircraftService implements AbstractService<Aircraft, Integer> {

  private final AircraftRepository aircraftRepository;

  public AircraftService(AircraftRepository aircraftRepository) {
    this.aircraftRepository = aircraftRepository;
  }

  @Override
  public List<Aircraft> getAll() {
    return aircraftRepository.findAll();
  }

  @Override
  public Aircraft getById(Integer id) {
    return aircraftRepository.getOne(id);
  }

  public List<Aircraft> getAllByAviacompanyId(Integer id) {
    return aircraftRepository.getAircraftsByAviacompanyId(id);
  }

  @Override
  public Aircraft create(Aircraft aircraft) {
    return aircraftRepository.save(aircraft);
  }

  @Override
  public Aircraft update(Integer id, Aircraft aircraft) {
    if (aircraftRepository.findById(id).isPresent()) {
      return aircraftRepository.save(aircraft);
    } else {
      return null;
    }

  }

  @Override
  public void deleteById(Integer id) {
    if (aircraftRepository.findById(id).isPresent()) {
      aircraftRepository.deleteById(id);
    }

  }
}
