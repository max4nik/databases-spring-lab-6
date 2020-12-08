package ua.lviv.iot.flight.service;

import org.springframework.stereotype.Service;
import ua.lviv.iot.flight.domain.Pilot;
import ua.lviv.iot.flight.repository.PilotRepository;

import java.util.List;

@Service
public class PilotService implements AbstractService<Pilot, Integer> {

  private final PilotRepository pilotRepository;

  public PilotService(PilotRepository pilotRepository) {
    this.pilotRepository = pilotRepository;
  }

  @Override
  public List<Pilot> getAll() {
    return pilotRepository.findAll();
  }

  @Override
  public Pilot getById(Integer id) {
    return pilotRepository.getOne(id);
  }

  @Override
  public Pilot create(Pilot pilot) {
    return pilotRepository.save(pilot);
  }

  @Override
  public Pilot update(Integer id, Pilot pilot) {
    if (pilotRepository.findById(id).isPresent()) {
      return pilotRepository.save(pilot);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (pilotRepository.findById(id).isPresent()) {
      pilotRepository.deleteById(id);
    }
  }
}
