package ua.lviv.iot.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.flight.domain.Aircraft;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
  List<Aircraft> getAircraftsByAviacompanyId(Integer aviacompany_id);
}
