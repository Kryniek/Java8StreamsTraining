package com.kryniek.training.Java8Streams;

import static com.kryniek.training.Java8Streams.sampleData.UserSampleData.getUsers;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import com.kryniek.training.Java8Streams.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex11Reduce {
    @Test
    void java7SalarySum() {
        BigDecimal salarySum = BigDecimal.ZERO;

        for (User user : getUsers()) {
            salarySum = salarySum.add(user.getSalary());
        }

        assertThat(salarySum).isEqualTo(getExpectedSalarySum());
    }

    @Test
    void java8SalarySum() {
        BigDecimal salarySum = getUsers()
                .stream()
                .map(User::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(salarySum).isEqualTo(getExpectedSalarySum());
    }

    @Test
    void java7MaxSalary() {
        BigDecimal maxSalary = BigDecimal.ZERO;

        for (User user : getUsers()) {
            if (maxSalary.compareTo(user.getSalary()) < 0) {
                maxSalary = user.getSalary();
            }
        }

        assertThat(maxSalary).isEqualTo(getExpectedMaxSalary());
    }

    @Test
    void java8MaxSalary() {
        BigDecimal maxSalary = getUsers()
                .stream()
                .map(User::getSalary)
                .reduce(BigDecimal::max)
                .orElseThrow();

        assertThat(maxSalary).isEqualTo(getExpectedMaxSalary());
    }

    private BigDecimal getExpectedSalarySum() {
        return new BigDecimal("19708.89");
    }

    private BigDecimal getExpectedMaxSalary() {
        return new BigDecimal("9000");
    }
}
