package com.kryniek.training.Java8Streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex12Sort {
    @Test
    void java7AscendingSort() {
        List<Integer> sortedNumbers = new ArrayList<>(getNumbers());

        sortedNumbers.sort(null);

        assertThat(sortedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedAscendingNumbers());
    }

    @Test
    void java8AscendingSort() {
        List<Integer> sortedNumbers = getNumbers()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(sortedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedAscendingNumbers());
    }

    @Test
    void java7DescendingSort() {
        List<Integer> sortedNumbers = new ArrayList<>(getNumbers());

        sortedNumbers.sort(Comparator.reverseOrder());

        assertThat(sortedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedDescendingNumbers());
    }

    @Test
    void java8DescendingSort() {
        List<Integer> sortedNumbers = getNumbers()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertThat(sortedNumbers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedDescendingNumbers());
    }

    private List<Integer> getNumbers() {
        return List.of(7, 4, 9, 1, 2, 0, 5, 3, 8, 6);
    }

    private List<Integer> getExpectedAscendingNumbers() {
        return List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private List<Integer> getExpectedDescendingNumbers() {
        return List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
    }
}
