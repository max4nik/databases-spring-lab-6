package ua.lviv.iot.flight.service;

import org.springframework.stereotype.Service;
import ua.lviv.iot.flight.domain.Aviacompany;
import ua.lviv.iot.flight.repository.AviacompanyRepository;

import java.util.List;

@Service
public class AviacompanyService implements AbstractService<Aviacompany, Integer> {

  private final AviacompanyRepository aviacompanyRepository;

  public AviacompanyService(AviacompanyRepository aviacompanyRepository) {
    this.aviacompanyRepository = aviacompanyRepository;
  }

  @Override
  public List<Aviacompany> getAll() {
    return aviacompanyRepository.findAll();
  }

  @Override
  public Aviacompany getById(Integer id) {
    return aviacompanyRepository.getOne(id);
  }

  @Override
  public Aviacompany create(Aviacompany aviacompany) {
    return aviacompanyRepository.save(aviacompany);
  }

  @Override
  public Aviacompany update(Integer id, Aviacompany aviacompany) {
    if (aviacompanyRepository.findById(id).isPresent()) {
      return aviacompanyRepository.save(aviacompany);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (aviacompanyRepository.findById(id).isPresent()) {
      aviacompanyRepository.deleteById(id);
    }
  }
}
