package com.bnta.hellospringboot.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args){

        SpringApplication.run(Main.class, args);

    }
}
// To do
    // add some error catches
    // make a better id system that or change update so that it finds the car rather than basing on the index
