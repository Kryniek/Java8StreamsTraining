package com.kryniek.training.Java8Streams.sampleData;

import static com.kryniek.training.Java8Streams.enums.Sex.FEMALE;
import static com.kryniek.training.Java8Streams.enums.Sex.MALE;
import static com.kryniek.training.Java8Streams.enums.Sex.UNICORN;

import java.util.List;
import java.util.stream.Collectors;

import com.kryniek.training.Java8Streams.enums.Sex;
import com.kryniek.training.Java8Streams.model.User;

public class ChildrenSampleData {
    public static List<User> getChildren(Integer limit) {
        return List.of(getChild(1, FEMALE),
                getChild(2, FEMALE),
                getChild(3, MALE),
                getChild(4, MALE),
                getChild(5, UNICORN),
                getChild(6, UNICORN))
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static User getChild(Integer id, Sex sex) {
        return User.builder()
                .id(1)
                .name("Name1")
                .surname("Surname1")
                .sex(sex)
                .age(id + 5)
                .children(List.of())
                .build();
    }
}
