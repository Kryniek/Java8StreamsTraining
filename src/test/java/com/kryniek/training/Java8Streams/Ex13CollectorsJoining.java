package com.kryniek.training.Java8Streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex13CollectorsJoining {
    @Test
    void java7() {
        StringBuilder numbersWithDelimiter = new StringBuilder();
        List<Integer> numbers = getNumbers();

        for (Integer number : numbers) {
            numbersWithDelimiter.append(number);

            boolean isLastNumber = Integer.valueOf(numbers.indexOf(number)).equals(numbers.size() - 1);
            if (!isLastNumber) {
                numbersWithDelimiter.append(", ");
            }
        }

        assertThat(numbersWithDelimiter.toString()).isEqualTo(getExpectedNumbers());
    }

    @Test
    void java8() {
        String numbersWithDelimiter = getNumbers()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        assertThat(numbersWithDelimiter).isEqualTo(getExpectedNumbers());
    }

    private List<Integer> getNumbers() {
        return List.of(7, 4, 9, 1, 2, 0, 5, 3, 8, 6);
    }

    private String getExpectedNumbers() {
        return "7, 4, 9, 1, 2, 0, 5, 3, 8, 6";
    }
}
