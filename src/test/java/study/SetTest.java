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
    @DisplayName("Set의 size() 메소드를 활용해서 Set의 크기를 검증")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드 제거")
    void contains(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1| true",
            "2| true",
            "3| true",
            "4| false"
    }, delimiter = '|')
    @DisplayName("Set의 contains() 메소드에 input 값이 포함되어 있는지 검증")
    void contains_result(Integer input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
