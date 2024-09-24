package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    void testForSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testContains(int checkValue) {
        assertThat(numbers.contains(checkValue)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5"})
    void testRemove(int checkValue) {
        if (1 <= checkValue && checkValue < 4) {
            assertThat(numbers.contains(checkValue)).isTrue();
        } else {
            assertThat(numbers.contains(checkValue)).isFalse();
        }
    }
}
