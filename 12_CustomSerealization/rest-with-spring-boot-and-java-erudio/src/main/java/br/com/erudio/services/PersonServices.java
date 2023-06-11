package br.com.erudio.services;

import java.util.List;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    
    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
 
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class); 
    }
    public PersonVO findById(Long id){
       

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
        }


    public PersonVO create(PersonVO person){

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }
     

    public PersonVO update(PersonVO person){
        var entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddres(person.getAddres());
            entity.setGender(person.getGender());
        
            var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
            return vo;
    }

    public void delete(Long id){

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
            repository.delete(entity);
    }
     

}
