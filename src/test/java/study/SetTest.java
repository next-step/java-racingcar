package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Object> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기를 확인한다.")
    @Test
    void set_size() {
        int expected = 3;
        assertEquals(expected, numbers.size());
    }

    @DisplayName("set이 포함하는 값을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("set이 포함하는 요소인지 여부를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void set_does_contain(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}
