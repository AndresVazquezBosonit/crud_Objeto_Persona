package com.crud.objectPerson.service;

import com.crud.objectPerson.entity.Persona;
import com.crud.objectPerson.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
  @Autowired private PersonaRepository personaRepository;
  public Persona addPerson(Persona p) {

    return personaRepository.save(p);
  }

  public Optional<Persona> findPerson(long id) {
    return personaRepository.findById(id);
  }

  public List<Persona> listPerson() {
    return personaRepository.findAll();
  }

  public void deletePerson(long id) {
    personaRepository.deleteById(id);
  }

  public Persona updatePerson(Persona p, long id) {
    Optional<Persona> personToUpdate = personaRepository.findById(id);
    if (personToUpdate.isPresent()) {
      p.setNombre(Optional.ofNullable(p.getNombre()).orElse(personToUpdate.get().getNombre()));
      p.setPoblacion(
          Optional.ofNullable(p.getPoblacion()).orElse(personToUpdate.get().getPoblacion()));
      p.setEdad(p.getEdad() == 0 ? personToUpdate.get().getEdad() : p.getEdad());
      p.setId(id);
      return personaRepository.save(p);
    } else {
      p.setId(id);
      p.setNombre("this id does not exist");
      p.setPoblacion("this id does not exist");
      p.setEdad(0);
      return p;
    }
  }
}
