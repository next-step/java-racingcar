package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
    void setSize() {
        int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertTrue(numbers.contains(number), () -> "numbers don't contain: " + number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithCsv(int number, boolean expected) {
        boolean actual = numbers.contains(number);
        assertEquals(expected, actual, () -> "Expected: " + expected + ", actual: " + actual + " for number: " + number);
    }
}