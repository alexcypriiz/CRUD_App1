package ru.podlubnyy.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.podlubnyy.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Vlad"));
        people.add(new Person(++PEOPLE_COUNT, "Alex"));
        people.add(new Person(++PEOPLE_COUNT, "German"));
        people.add(new Person(++PEOPLE_COUNT, "Chris"));
        people.add(new Person(++PEOPLE_COUNT, "Samara"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
