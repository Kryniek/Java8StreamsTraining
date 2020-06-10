package com.kryniek.training.Java8Streams.sampleData;

import static com.kryniek.training.Java8Streams.enums.Sex.FEMALE;
import static com.kryniek.training.Java8Streams.enums.Sex.MALE;
import static com.kryniek.training.Java8Streams.enums.Sex.UNICORN;
import static com.kryniek.training.Java8Streams.sampleData.ChildrenSampleData.getChildren;

import java.math.BigDecimal;
import java.util.List;

import com.kryniek.training.Java8Streams.model.User;

public class UserSampleData {
    public static List<User> getUsers() {
        return List.of(
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
                        .id(2)
                        .name("Riley")
                        .surname("Reid")
                        .sex(UNICORN)
                        .age(28)
                        .salary(new BigDecimal("2700.12"))
                        .children(getChildren(5))
                        .build(),
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
                        .id(4)
                        .name("Lisa")
                        .surname("Ann")
                        .sex(FEMALE)
                        .age(48)
                        .salary(new BigDecimal("9000"))
                        .children(getChildren(6))
                        .build(),
                User.builder()
                        .id(5)
                        .name("Elsa")
                        .surname("Jean")
                        .sex(UNICORN)
                        .age(23)
                        .salary(new BigDecimal("4500.99"))
                        .children(List.of())
                        .build(),
                User.builder()
                        .id(6)
                        .name("Johnny")
                        .surname("Sins")
                        .sex(MALE)
                        .age(29)
                        .salary(new BigDecimal("1400.99"))
                        .children(List.of())
                        .build());
    }
}
