package com.rubayet.demo.dao;

import com.rubayet.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id,Person person);

    default int insertPerson(Person person){
        return insertPerson(UUID.randomUUID(),person);
    }

    List<Person> selectAllPerson();

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person newPerson);

    Optional<Person> selectPersonByID(UUID id);
}
