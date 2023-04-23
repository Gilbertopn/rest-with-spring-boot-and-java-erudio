package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.model.Person;
//import ch.qos.logback.classic.Logger;


import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    
    private AtomicLong counter = new AtomicLong();
   // private Logger Logger;

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        
        for (int i = 0; i< 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        
        return persons;
    }
    public Person findById(String id){
       
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leando");
        person.setLastName("Costa");
        person.setAddres("Uberlândia- Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }


    public Person create(Person person){
        return person;
    }
     

    public Person update(Person person){
        return person;
    }

    public void delete(String id){

    }
     
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name"+ i);
        person.setLastName("Last name"+ i);
        person.setAddres("Some addres in Brasil"+ i);
        person.setGender("Male");
        return person;
    }

}
