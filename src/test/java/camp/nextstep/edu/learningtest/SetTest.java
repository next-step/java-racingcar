package camp.nextstep.edu.learningtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("size 메서드는 set에 담긴 크기를 반환한다")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    @DisplayName("contains 메서드는 해당 값이 존재한다면 true를 반환한다")
    void contains(int input) {
        assertThat(numbers.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({ "1,true", "2,true", "3,true", "4,false", "5,false" })
    @DisplayName("contains 메서드는 해당 값이 존재여부에 따라 true 또는 false를 반환한다")
    void contains2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
