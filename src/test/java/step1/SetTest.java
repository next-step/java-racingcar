package step1;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void hashSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void numbersContains() {
        assertThat(numbers).contains(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void numbersContainsByParameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:4", "2:5", "3:"}, delimiter = ':')
    void shouldBeNotEqual(Integer expectTrue, Integer expectFalse) {
        assertThat(numbers.contains(expectTrue)).isTrue();
        assertThat(numbers.contains(expectFalse)).isFalse();
    }
}
