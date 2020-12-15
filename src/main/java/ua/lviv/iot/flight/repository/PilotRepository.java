package ua.lviv.iot.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.flight.domain.Pilot;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {
}
