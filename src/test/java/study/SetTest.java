package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetTest {

    private HashSet<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set size 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set contains 단순 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set contains 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains_with_parameterized(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set contains 테스트 - 실패")
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"})
    void containsWithFail(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
