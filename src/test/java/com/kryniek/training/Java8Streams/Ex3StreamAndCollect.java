package com.kryniek.training.Java8Streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex3StreamAndCollect {
    @Test
    void java7() {
        List<Integer> collectedNumbers = new ArrayList<>();

        for (Integer number : getNumbers()) {
            collectedNumbers.add(number);
        }

        assertThat(collectedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getNumbers());
    }

    @Test
    void java8() {
        List<Integer> collectedNumbers = getNumbers()
                .stream()
                .collect(Collectors.toList());

        assertThat(collectedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getNumbers());
    }

    private List<Integer> getNumbers() {
        return List.of(7, 4, 9, 1, 2, 0, 5, 3, 8, 6);
    }
}
