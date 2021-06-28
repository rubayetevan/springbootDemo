package com.rubayet.demo.dao;

import com.rubayet.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
    private static final List<Person> DB = new ArrayList<Person>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(person.getName(),id));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

}
