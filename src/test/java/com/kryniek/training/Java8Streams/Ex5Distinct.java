package com.kryniek.training.Java8Streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex5Distinct {
    @Test
    void java7() {
        List<Integer> collectedNumbers = new ArrayList<>();

        for (Integer number : getNumbers()) {
            if (!collectedNumbers.contains(number)) {
                collectedNumbers.add(number);
            }
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
                .distinct()
                .collect(Collectors.toList());

        assertThat(collectedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedNumbers());
    }

    private List<Integer> getNumbers() {
        return List.of(7, 7, 9, 9, 2, 2, 5, 5, 5, 5);
    }

    private List<Integer> getExpectedNumbers() {
        return List.of(7, 9, 2, 5);
    }
}
