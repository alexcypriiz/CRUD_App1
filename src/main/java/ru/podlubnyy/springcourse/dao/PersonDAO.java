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
        people.add(new Person(++PEOPLE_COUNT, "Vlad", 23, "themetronome@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 24, "cypriiz@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "German", 22, "sblgerman@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Chris", 37, "chrispratt@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Samara", 29,"missladymylove@gmail.com"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
