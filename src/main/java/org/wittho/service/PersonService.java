package org.wittho.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.wittho.customExceptions.RequiredField;
import org.wittho.dto.PersonDto;
import org.wittho.model.PersonModel;
import org.wittho.repository.PersonRepository;

@ApplicationScoped
public class PersonService {

  @Inject
  private PersonRepository repository;
  
  public String test() {
    return "Ok!";
  }
  
  public List<PersonModel> listAll() {
    return repository.listAll();
  }
  
  public PersonModel getById(Long id) {
    return repository.findById(id);
  }
  
  @Transactional
  public String save(PersonDto personDto) throws RequiredField, Exception {
    PersonModel newPerson = new PersonModel();
    
    if (personDto.getName().isBlank()) {
      throw new RequiredField("O campo nome é obrigatório.");
    }
    
    if (personDto.getAge() < 18) {
      throw new RequiredField("A idade mínima é de 18 anos.");
    }
    
    newPerson.setName(personDto.getName());
    newPerson.setAge(personDto.getAge());
    
    repository.persist(newPerson);
    
    return "Person_added.";
  }
  
  @Transactional
  public String update(Long id, PersonDto personDto) {
    PersonModel toBeUpdated = repository.findById(id);
    
    toBeUpdated.setName(personDto.getName());
    toBeUpdated.setAge(personDto.getAge());
    
    repository.deleteById(toBeUpdated.getId());
    repository.persist(toBeUpdated);
    
    return "Person_updated.";
  }
  
  @Transactional
  public String delete(Long id) {
    repository.deleteById(id);
    
    return "Person_removed.";
  }
}
