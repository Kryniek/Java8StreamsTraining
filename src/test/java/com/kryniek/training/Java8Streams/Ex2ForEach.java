package com.kryniek.training.Java8Streams;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex2ForEach {
    @Test
    void java7() {
        for (Integer number : getNumbers()) {
            System.out.println("Java 7 number: " + number);
        }
    }

    @Test
    void java8() {
        getNumbers().forEach(number -> System.out.println("Java 8 number: " + number));
    }

    private List<Integer> getNumbers() {
        return List.of(7, 4, 9, 1, 2, 0, 5, 3, 8, 6);
    }
}
