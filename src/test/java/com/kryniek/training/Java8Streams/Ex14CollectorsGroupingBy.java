package com.kryniek.training.Java8Streams;

import static com.kryniek.training.Java8Streams.enums.Sex.FEMALE;
import static com.kryniek.training.Java8Streams.enums.Sex.MALE;
import static com.kryniek.training.Java8Streams.enums.Sex.UNICORN;
import static com.kryniek.training.Java8Streams.sampleData.ChildrenSampleData.getChildren;
import static com.kryniek.training.Java8Streams.sampleData.UserSampleData.getUsers;
import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kryniek.training.Java8Streams.enums.Sex;
import com.kryniek.training.Java8Streams.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex14CollectorsGroupingBy {
    @Test
    void java7GroupingBy() {
        Map<Sex, List<User>> sexesToUsers = new HashMap<>();

        for (User user : getUsers()) {
            sexesToUsers.putIfAbsent(user.getSex(), new ArrayList<>());
            sexesToUsers.get(user.getSex()).add(user);
        }

        assertThat(sexesToUsers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedSexesToUsers());
    }

    @Test
    void java8GroupingBy() {
        Map<Sex, List<User>> sexesToUsers = getUsers()
                .stream()
                .collect(Collectors.groupingBy(User::getSex));

        assertThat(sexesToUsers)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedSexesToUsers());
    }

    @Test
    void java7GroupingByCounting() {
        Map<Sex, Long> sexesToQuantities = new HashMap<>();

        for (User user : getUsers()) {
            sexesToQuantities.putIfAbsent(user.getSex(), 0L);
            sexesToQuantities.compute(user.getSex(), (sex, quantity) -> quantity = quantity + 1);
        }

        assertThat(sexesToQuantities)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedSexesToQuantities());
    }

    @Test
    void java8GroupingByCounting() {
        Map<Sex, Long> sexesToQuantities = getUsers()
                .stream()
                .collect(Collectors.groupingBy(User::getSex, Collectors.counting()));

        assertThat(sexesToQuantities)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedSexesToQuantities());
    }

    private Map<Sex, List<User>> getExpectedSexesToUsers() {
        return Map.ofEntries(
                entry(MALE, List.of(
                        User.builder()
                                .id(3)
                                .name("Alex")
                                .surname("Adams")
                                .sex(MALE)
                                .age(32)
                                .salary(new BigDecimal("906.10"))
                                .children(getChildren(3))
                                .build(),
                        User.builder()
                                .id(6)
                                .name("Johnny")
                                .surname("Sins")
                                .sex(MALE)
                                .age(29)
                                .salary(new BigDecimal("1400.99"))
                                .children(List.of())
                                .build())),
                entry(FEMALE, List.of(
                        User.builder()
                                .id(1)
                                .name("Mia")
                                .surname("Khalifa")
                                .sex(FEMALE)
                                .age(26)
                                .salary(new BigDecimal("1200.69"))
                                .children(getChildren(1))
                                .build(),
                        User.builder()
                                .id(4)
                                .name("Lisa")
                                .surname("Ann")
                                .sex(FEMALE)
                                .age(48)
                                .salary(new BigDecimal("9000"))
                                .children(getChildren(6))
                                .build())),
                entry(UNICORN, List.of(
                        User.builder()
                                .id(2)
                                .name("Riley")
                                .surname("Reid")
                                .sex(UNICORN)
                                .age(28)
                                .salary(new BigDecimal("2700.12"))
                                .children(getChildren(5))
                                .build(),
                        User.builder()
                                .id(5)
                                .name("Elsa")
                                .surname("Jean")
                                .sex(UNICORN)
                                .age(23)
                                .salary(new BigDecimal("4500.99"))
                                .children(List.of())
                                .build())));
    }

    private Map<Sex, Long> getExpectedSexesToQuantities() {
        return Map.ofEntries(
                entry(MALE, 2L),
                entry(FEMALE, 2L),
                entry(UNICORN, 2L));
    }
}
