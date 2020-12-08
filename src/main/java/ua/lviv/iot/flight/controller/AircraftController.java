package ua.lviv.iot.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.flight.domain.Aircraft;
import ua.lviv.iot.flight.dto.AircraftDto;
import ua.lviv.iot.flight.service.AircraftService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/aircrafts")
@RestController
public class AircraftController {
  private final AircraftService aircraftService;

  public AircraftController(AircraftService aircraftService) {
    this.aircraftService = aircraftService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AircraftDto>> getAll() {
    List<Aircraft> aircrafts = aircraftService.getAll();
    List<AircraftDto> aircraftDtos = new ArrayList<>();
    for (Aircraft aircraft : aircrafts) {
      AircraftDto aircraftDto = new AircraftDto(
          aircraft.getId(),
          aircraft.getModelName(),
          aircraft.getType(),
          aircraft.getYearsInUse(),
          aircraft.getMaxSeats(),
          aircraft.getAviacompany().getName()
      );
      aircraftDtos.add(aircraftDto);
    }
    return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AircraftDto> getById(@PathVariable Integer id) {
    Aircraft aircraft = aircraftService.getById(id);
    if (aircraft != null) {
      AircraftDto aircraftDto = new AircraftDto(
          aircraft.getId(),
          aircraft.getModelName(),
          aircraft.getType(),
          aircraft.getYearsInUse(),
          aircraft.getMaxSeats(),
          aircraft.getAviacompany().getName()
      );
      return new ResponseEntity<>(aircraftDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Aircraft newAircraft) {
    aircraftService.create(newAircraft);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AircraftDto> update(@PathVariable Integer id,
                                            @RequestBody Aircraft aircraft) {
    Aircraft aircraftOld = aircraftService.getById(id);
    if (aircraftOld != null) {
      aircraft.setId(id);
      aircraftService.update(id, aircraft);
      AircraftDto aircraftOldDto = new AircraftDto(
          aircraft.getId(),
          aircraft.getModelName(),
          aircraft.getType(),
          aircraft.getYearsInUse(),
          aircraft.getMaxSeats(),
          aircraft.getAviacompany().getName()
      );
      return new ResponseEntity<>(aircraftOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (aircraftService.getById(id) != null) {
      aircraftService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(method = RequestMethod.GET,
      value = "/aviacompany/{id}")
  public @ResponseBody
  ResponseEntity<List<AircraftDto>> getAllByCountry(@PathVariable Integer id) {
    List<Aircraft> aircrafts = aircraftService.getAllByAviacompanyId(id);
    if (aircrafts != null) {
      List<AircraftDto> aircraftDtos = new ArrayList<>();
      for (Aircraft aircraft : aircrafts) {
        AircraftDto aircraftDto = new AircraftDto(
            aircraft.getId(),
            aircraft.getModelName(),
            aircraft.getType(),
            aircraft.getYearsInUse(),
            aircraft.getMaxSeats(),
            aircraft.getAviacompany().getName()
        );
        aircraftDtos.add(aircraftDto);
      }
      return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
