package com.kryniek.training.Java8Streams;

import static com.kryniek.training.Java8Streams.enums.Sex.MALE;
import static com.kryniek.training.Java8Streams.sampleData.ChildrenSampleData.getChildren;
import static com.kryniek.training.Java8Streams.sampleData.UserSampleData.getUsers;
import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import com.kryniek.training.Java8Streams.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex9FindFirst {
    @Test
    void java7() {
        User firstMaleUser = null;

        for (User user : getUsers()) {
            if (user.getSex().equals(MALE)) {
                firstMaleUser = user;
                break;
            }
        }
        if (isNull(firstMaleUser)) {
            throw new NoSuchElementException();
        }

        assertThat(firstMaleUser)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedUser());
    }

    @Test
    void java8() {
        User firstMaleUser = getUsers()
                .stream()
                .filter(user -> user.getSex().equals(MALE))
                .findFirst() //similar: allMatch / anyMatch / noneMatch / findAny
                .orElseThrow(NoSuchElementException::new);

        assertThat(firstMaleUser)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedUser());
    }

    private User getExpectedUser() {
        return User.builder()
                .id(3)
                .name("Alex")
                .surname("Adams")
                .sex(MALE)
                .age(32)
                .salary(new BigDecimal("906.10"))
                .children(getChildren(3))
                .build();
    }
}
