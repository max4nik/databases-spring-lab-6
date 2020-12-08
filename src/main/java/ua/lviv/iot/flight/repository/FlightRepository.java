package ua.lviv.iot.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.flight.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
