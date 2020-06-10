package com.kryniek.training.Java8Streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex6MapBasic {
    @Test
    void java7() {
        List<Integer> collectedNumbers = new ArrayList<>();

        for (Integer number : getNumbers()) {
            collectedNumbers.add(number + 1);
        }

        assertThat(collectedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedNumbers());
    }

    @Test
    void java8() {
        List<Integer> collectedNumbers = getNumbers()
                .stream()
                .map(number -> number + 1)
                .collect(Collectors.toList());

        assertThat(collectedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedNumbers());
    }

    private List<Integer> getNumbers() {
        return List.of(7, 4, 9, 1, 2, 0, 5, 3, 8, 6);
    }

    private List<Integer> getExpectedNumbers() {
        return List.of(8, 5, 10, 2, 3, 1, 6, 4, 9, 7);
    }
}
