package br.com.erudio.services;

import java.util.List;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    
    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
 
        return repository.findAll();
    }
    public Person findById(Long id){
       

        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }


    public Person create(Person person){
        return repository.save(person);
    }
     

    public Person update(Person person){
        var entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddres(person.getAddres());
            entity.setGender(person.getGender());
        
        return repository.save(person);
    }

    public void delete(Long id){

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            repository.delete(entity);
    }
     

}
