package com.bnta.hellospringboot.counterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootApplicationCounter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);
    }

    // Create initial counter
    static int count = 0;

    // Create method to get current count from localhost:8080/current-count
    @GetMapping("/current-count")
    int currentCount(){
        return count;
    }
    // Create method to increment the count by localhost:8080/increment-count
    @GetMapping("/increment-count")
    void incrementCount(){
        ++count;
    }
    // Create method to decrement the count by localhost:8080/decrement-count
    @GetMapping("/decrement-count")
    void decrementCount(){
        --count;
    }
    // All your code should be inside this one class
    // add @RestController to you expose methods as REST services to clients
    // create a variable static int count = 0;
    // All methods should have a @GetMapping
    // Test your api with chrome
}