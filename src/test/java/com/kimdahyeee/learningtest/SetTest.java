package com.kimdahyeee.learningtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @Test
    @DisplayName("Set 크기 확인하는 학습 테스트")
    void setSize() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @DisplayName("Set Collection의 contains()메소드 학습 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest(name = "{index} {displayName} input = {0} expected = {1}")
    @DisplayName("Set Collection의 contains()메소드 실패 케이스 학습 테스트")
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsFail(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }
}
