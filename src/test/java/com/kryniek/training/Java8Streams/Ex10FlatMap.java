package com.kryniek.training.Java8Streams;

import static com.kryniek.training.Java8Streams.enums.Sex.UNICORN;
import static com.kryniek.training.Java8Streams.sampleData.ChildrenSampleData.getChild;
import static com.kryniek.training.Java8Streams.sampleData.UserSampleData.getUsers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kryniek.training.Java8Streams.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex10FlatMap {
    @Test
    void java7() {
        List<User> unicornChildren = new ArrayList<>();

        for (User user : getUsers()) {
            for (User child : user.getChildren()) {
                if (child.getSex().equals(UNICORN)) {
                    unicornChildren.add(child);
                }
            }
        }

        assertThat(unicornChildren)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedUnicornChildren());
    }

    @Test
    void java8() {
        List<User> unicornChildren = getUsers()
                .stream()
                .flatMap(user -> user.getChildren()
                        .stream()
                        .filter(child -> child.getSex().equals(UNICORN)))
                .collect(Collectors.toList());

        assertThat(unicornChildren)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedUnicornChildren());
    }

    private List<User> getExpectedUnicornChildren() {
        return List.of(
                getChild(5, UNICORN),
                getChild(5, UNICORN),
                getChild(6, UNICORN));
    }
}
