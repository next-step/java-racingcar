package study.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
        Assertions.assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(Integer input) {
        Assertions.assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true"})
    void containsSuccess(Integer number, Boolean result) {
        Assertions.assertThat(numbers.contains(number)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,false", "null,false"}, nullValues = "null")
    void containsFail(Integer number, Boolean result) {
        Assertions.assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
