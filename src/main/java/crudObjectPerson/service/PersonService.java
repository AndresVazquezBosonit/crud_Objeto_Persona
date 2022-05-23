package crudObjectPerson.service;

import crudObjectPerson.entity.Persona;
import crudObjectPerson.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
  @Autowired private PersonaRepository personaRepository;
  @PostConstruct
  public void initBean(){
    System.out.println("Init Bean!!");
  }
  @PreDestroy void preDestroy(){
    System.out.println("PreDestroy Bean");
  }
  public Persona addPerson(Persona p) {

    return personaRepository.save(p);
  }

  public Optional<Persona> findPerson(long id) {
    return personaRepository.findById(id);
  }

  public List<Persona> listPerson() {
    return personaRepository.findAll();
  }

  public String deletePerson(long id) {
    Optional<Persona> personaToDeleted = personaRepository.findById(id);
    if (personaToDeleted.isPresent()) {
      personaRepository.deleteById(id);
      return "Has been deleted: "
              + personaToDeleted.get().getNombre()
              + " from: "
              + personaToDeleted.get().getPoblacion()
              + " with id: "
              + personaToDeleted.get().getId();
    } else {
      return "The person does not exist";
    }
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
