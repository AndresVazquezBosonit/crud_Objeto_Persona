package crudObjectPerson.controller;

import crudObjectPerson.entity.Persona;
import crudObjectPerson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonController {

  @Autowired PersonService personService;

  // Get Person list
  @GetMapping
  public List<Persona> getPersons() {
    return personService.listPerson();
  }
  // Get Person by id
  @GetMapping("/{id}")
  public Optional<Persona> getPerson(@PathVariable long id) {
    return personService.findPerson(id);
  }
  // Post new Person
  @PostMapping
  public Persona postPerson(@RequestBody Persona p) {
    return personService.addPerson(p);
  }
  // Delete Person by id
  @DeleteMapping("/{id}")
  public String deletePerson(@PathVariable long id) {
    return personService.deletePerson(id);
  }
  // Update Person by id in
  @PutMapping("{id}")
  public Persona putPerson(@PathVariable Long id, @RequestBody Persona p) {
    return personService.updatePerson(p, id);
  }
}
