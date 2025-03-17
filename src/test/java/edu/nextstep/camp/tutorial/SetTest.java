package edu.nextstep.camp.tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetTest {
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
    void checkNumbersSize() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsWithValueSource(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void containsWithCsvSource(int value, boolean expected) {
        assertEquals(expected, numbers.contains(value));
    }
}