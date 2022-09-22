package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    void contains() {
        assertThat(numbers).contains(1,2,3);
    }

    @DisplayName("@CsvSource를 이용해 1,2,3이면 true 4 이면 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false"})
    void csvSource(String num, boolean expected) {
        boolean actual = numbers.contains(Integer.parseInt(num));
        assertEquals(expected, actual);
    }
}
