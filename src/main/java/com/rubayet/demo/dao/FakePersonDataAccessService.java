package com.rubayet.demo.dao;

import com.rubayet.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static final List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(person.getName(), id));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personMaybe = selectPersonByID(id);
        if (personMaybe.isPresent()) {
            DB.remove(personMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonByID(UUID id, Person newPerson) {
        return selectPersonByID(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if (indexOfPersonToUpdate > 0) {
                DB.set(indexOfPersonToUpdate, newPerson);
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

}
