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
    @DisplayName("numbers set의 size가 3인지 확인")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("numbers에 해당 숫자들이 포함되는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("numbers에 1, 2, 3은 존재하고 4, 5는 존재하지 않는지 확인")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsCheck(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
