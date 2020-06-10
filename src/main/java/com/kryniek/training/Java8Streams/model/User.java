package com.kryniek.training.Java8Streams.model;

import java.math.BigDecimal;
import java.util.List;

import com.kryniek.training.Java8Streams.enums.Sex;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private Integer id;
    private String name;
    private String surname;
    private Sex sex;
    private Integer age;
    private BigDecimal salary;
    private List<User> children;
}