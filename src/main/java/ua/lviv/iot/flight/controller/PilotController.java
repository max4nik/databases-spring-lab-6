package ua.lviv.iot.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.flight.domain.Pilot;
import ua.lviv.iot.flight.dto.PilotDto;
import ua.lviv.iot.flight.service.PilotService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/pilots")
@RestController
public class PilotController {
  private final PilotService pilotService;

  public PilotController(PilotService pilotService) {
    this.pilotService = pilotService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PilotDto>> getAll() {
    List<Pilot> pilots = pilotService.getAll();
    List<PilotDto> pilotDtos = new ArrayList<>();
    for (Pilot pilot : pilots) {
      PilotDto flightDto = new PilotDto(
          pilot.getId(),
          pilot.getSurName(),
          pilot.getName(),
          pilot.getPosition(),
          pilot.getFlights().size()
      );
      pilotDtos.add(flightDto);
    }
    return new ResponseEntity<>(pilotDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<PilotDto> getById(@PathVariable Integer id) {
    Pilot pilot = pilotService.getById(id);
    if (pilot != null) {
      PilotDto pilotDto = new PilotDto(
          pilot.getId(),
          pilot.getSurName(),
          pilot.getName(),
          pilot.getPosition(),
          pilot.getFlights().size()
      );
      return new ResponseEntity<>(pilotDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Pilot newPilot) {
    pilotService.create(newPilot);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<PilotDto> update(@PathVariable Integer id,
                                         @RequestBody Pilot pilot) {
    Pilot pilotOld = pilotService.getById(id);
    System.out.println(pilotOld);

    if (pilotOld != null) {
      pilot.setId(id);
      pilotService.update(id, pilot);
      PilotDto pilotOldDto = new PilotDto(
          pilotOld.getId(),
          pilotOld.getSurName(),
          pilotOld.getName(),
          pilotOld.getPosition(),
          pilotOld.getFlights().size()
      );
      return new ResponseEntity<>(pilotOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (pilotService.getById(id) != null) {
      pilotService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
