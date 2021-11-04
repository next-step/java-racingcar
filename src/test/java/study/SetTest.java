package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @DisplayName("Set의 크기를 확인할 수 있다.")
    @Test
    void size() {
        Assertions.assertThat(numbers.size()).isEqualTo(5);
    }

    @DisplayName("Set에 값이 존재하는지 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void containsTrue(int value) {
        Assertions.assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("Set에 값이 존재하면 true, 존재하지 않으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "6,false", "7,false", "5,true"})
    void contains(int value, boolean expect) {
        Assertions.assertThat(numbers.contains(value)).isEqualTo(expect);
    }
}
