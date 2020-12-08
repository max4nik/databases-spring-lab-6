package ua.lviv.iot.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.flight.domain.Aviacompany;
import ua.lviv.iot.flight.dto.AviacompanyDto;
import ua.lviv.iot.flight.service.AviacompanyService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/aviacompanies")
@RestController
public class AviacompanyController {
  private final AviacompanyService aviacompanyService;

  public AviacompanyController(AviacompanyService aviacompanyService) {
    this.aviacompanyService = aviacompanyService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<AviacompanyDto>> getAll() {
    List<Aviacompany> aviacompanies = aviacompanyService.getAll();
    List<AviacompanyDto> aviacompanyDtos = new ArrayList<>();
    for (Aviacompany aviacompany : aviacompanies) {
      AviacompanyDto aviacompanyDto = new AviacompanyDto(
          aviacompany.getId(),
          aviacompany.getName(),
          aviacompany.getCreationDate(),
          aviacompany.getAircrafts().size(),
          aviacompany.getFlights().size()
      );
      aviacompanyDtos.add(aviacompanyDto);
    }
    return new ResponseEntity<>(aviacompanyDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AviacompanyDto> getById(@PathVariable Integer id) {
    Aviacompany aviacompany = aviacompanyService.getById(id);
    if (aviacompany != null) {
      AviacompanyDto aviacompanyDto = new AviacompanyDto(
          aviacompany.getId(),
          aviacompany.getName(),
          aviacompany.getCreationDate(),
          aviacompany.getAircrafts().size(),
          aviacompany.getFlights().size()
      );
      return new ResponseEntity<>(aviacompanyDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Aviacompany newAviacompany) {
    aviacompanyService.create(newAviacompany);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AviacompanyDto> update(@PathVariable Integer id,
                                               @RequestBody Aviacompany aviacompany) {
    Aviacompany aviacompanyOld = aviacompanyService.getById(id);
    if (aviacompanyOld != null) {
      aviacompanyService.update(id, aviacompany);
      AviacompanyDto aviacompanyOldDto = new AviacompanyDto(
          aviacompanyOld.getId(),
          aviacompanyOld.getName(),
          aviacompanyOld.getCreationDate(),
          aviacompanyOld.getAircrafts().size(),
          aviacompanyOld.getFlights().size()
      );
      return new ResponseEntity<>(aviacompanyOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (aviacompanyService.getById(id) != null) {
      aviacompanyService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
