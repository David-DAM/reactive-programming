package com.david.reactiveprogramming.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetNames(){
        Flux<String> names = userService.getNames();

        names.subscribe(System.out::println);

        StepVerifier.create(names)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void testGetCharsFromNames(){
        Flux<String> names = userService.getCharsFromNames();

        names.subscribe(System.out::println);

        StepVerifier.create(names)
                .expectNextCount(30)
                .verifyComplete();
    }

}