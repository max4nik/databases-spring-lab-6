package ua.lviv.iot.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.flight.domain.Airport;
import ua.lviv.iot.flight.dto.AirportDto;
import ua.lviv.iot.flight.service.AirportService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/airports")
@RestController
public class AirportController {
  private final AirportService airportService;

  public AirportController(AirportService airportService) {
    this.airportService = airportService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AirportDto>> getAll() {
    List<Airport> airports = airportService.getAll();
    List<AirportDto> airportDtos = new ArrayList<>();
    for (Airport airport : airports) {
      AirportDto airportDto = new AirportDto(
          airport.getId(),
          airport.getName(),
          airport.getAmountOfWorkers(),
          airport.getCity(),
          airport.getFlightsFromAirport().size(),
          airport.getFlightsToAirport().size()
      );
      airportDtos.add(airportDto);
    }
    return new ResponseEntity<>(airportDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AirportDto> getById(@PathVariable Integer id) {
    Airport airport = airportService.getById(id);
    if (airport != null) {
      AirportDto airportDto = new AirportDto(
          airport.getId(),
          airport.getName(),
          airport.getAmountOfWorkers(),
          airport.getCity(),
          airport.getFlightsFromAirport().size(),
          airport.getFlightsToAirport().size()
      );
      return new ResponseEntity<>(airportDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Airport newAirport) {
    airportService.create(newAirport);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AirportDto> update(@PathVariable Integer id,
                                           @RequestBody Airport airport) {
    Airport airportOld = airportService.getById(id);
    if (airportOld != null) {
      airportService.update(id, airport);
      AirportDto airportOldDto = new AirportDto(
          airport.getId(),
          airport.getName(),
          airport.getAmountOfWorkers(),
          airport.getCity(),
          airport.getFlightsFromAirport().size(),
          airport.getFlightsToAirport().size()
      );
      return new ResponseEntity<>(airportOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (airportService.getById(id) != null) {
      airportService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
