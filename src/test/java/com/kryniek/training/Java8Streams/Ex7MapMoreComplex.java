package com.kryniek.training.Java8Streams;

import static com.kryniek.training.Java8Streams.sampleData.UserSampleData.getUsers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kryniek.training.Java8Streams.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex7MapMoreComplex {
    @Test
    void java7() {
        List<String> usersNamesAndSurnamesWithoutChildren = new ArrayList<>();

        for (User user : getUsers()) {
            if (isEmpty(user.getChildren())) {
                usersNamesAndSurnamesWithoutChildren.add(user.getName() + " " + user.getSurname());
            }
        }

        assertThat(usersNamesAndSurnamesWithoutChildren)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedNamesAndSurnames());
    }

    @Test
    void java8() {
        List<String> usersNamesAndSurnamesWithoutChildren = getUsers()
                .stream()
                .filter(user -> isEmpty(user.getChildren()))
                .map(user -> user.getName() + " " + user.getSurname())
                .collect(Collectors.toList());

        assertThat(usersNamesAndSurnamesWithoutChildren)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedNamesAndSurnames());
    }

    private List<String> getExpectedNamesAndSurnames() {
        return List.of("Elsa Jean", "Johnny Sins");
    }
}
