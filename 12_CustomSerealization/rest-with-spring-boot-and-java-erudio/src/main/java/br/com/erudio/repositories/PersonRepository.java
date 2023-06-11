package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

    PersonVO save(PersonVO person);}
