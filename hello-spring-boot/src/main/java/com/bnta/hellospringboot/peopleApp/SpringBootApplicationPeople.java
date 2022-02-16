package com.bnta.hellospringboot.peopleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootApplicationPeople {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationPeople.class, args);
    }

    // Create Persons and add them to list
    Person jake = new Person(1, "Jake", 24);
    Person nayan = new Person(2, "Nayan", 22);
    Person yang = new Person(3, "Yang", 32);
    Person robyn = new Person(4, "Robyn", 19);
    List<Person> people = List.of(jake, nayan,yang,robyn);

    // Build Person class
    static class Person{
        private Integer id;
        private String name;
        private Integer age;

        public Person(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }

    }

    @GetMapping("/people/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        // Create empty person output
        Person output = null;
        // Loop through people list, if ID matches -> assign person
        for (Person p :
                people) {
            if (id.equals(p.getId())) {
                output = p;
                break;
            }
        }
        return output;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        // Create empty list
        List<Person> output = null;
        // Assign all people to output if possible
        output = people;
        return output;
    }

    @PostMapping(path = "people")
    public void addPerson(@RequestBody @Valid Person person) {
        System.out.println(person);
    }

    // All your code should be inside this one class
    // add @RestController to you expose methods as REST services to clients
    // implement getPersonById
    // create another method that returns all people using @GetMapping("people")
    // test your api using chrome
}