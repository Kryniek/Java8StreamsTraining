package com.kryniek.training.Java8Streams;

import static java.util.Objects.nonNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex8Optional {
    @Test
    void java7Present() {
        Integer number = 123;

        if (nonNull(number)) {
            System.out.println("Java 7 number is present example.");
        } else {
            System.out.println("Never be shown.");
        }
    }

    @Test
    void java8Present() {
        Optional<Integer> number = Optional.of(123);
        number.ifPresentOrElse((n) -> System.out.println("Java 8 number is present example."),
                () -> System.out.println("Never be shown."));
    }

    @Test
    void java7Empty() {
        Integer number = null;

        if (nonNull(number)) {
            System.out.println("Never be shown.");
        } else {
            System.out.println("Java 7 number is empty example.");
        }
    }

    @Test
    void java8Empty() {
        Optional<Integer> number = Optional.ofNullable(null);
        number.ifPresentOrElse((n) -> System.out.println("Never be shown."),
                () -> System.out.println("Java 8 number is empty example."));
    }
}
