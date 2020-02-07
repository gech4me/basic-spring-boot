package com.example.demo.service;

import com.example.demo.repository.PersonBase;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonBase personBase;

    @Autowired
    public PersonService(@Qualifier("personRepository") PersonBase personBase) {
        this.personBase = personBase;
    }

    public int addPerson(Person person) {
        return personBase.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personBase.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personBase.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personBase.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personBase.updatePersonById(id, newPerson);
    }
}
