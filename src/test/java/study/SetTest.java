package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("size 크기 확인")
    @Test
    void sizeCheck() {
        assertEquals(numbers.size(), 3);
    }

    @DisplayName("값 확인 - true")
    @ParameterizedTest
    @ValueSource(ints ={1, 2, 3})
    void constainsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("값 확인 - true / false")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsFalseTest(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
