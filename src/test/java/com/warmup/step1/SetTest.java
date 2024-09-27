package com.warmup.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("numbers Set이 의도한 사이즈를 가지고 있는지 여부")
    @Test
    void isEquals_ShouldEqualExpectedSetSize() {
        int expectedValue = 3;

        assertThat(numbers).hasSize(expectedValue);
    }

    @DisplayName("Set이 각 항목을 포함하고 있는지 여부")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isTrue_ShouldReturnTrueExpectedValueSet(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("각 항목에 대해 파라미터에 매핑된 값을 반환하는지 여부")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void isEquals_ShouldEqualsExpectedValueSet(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}