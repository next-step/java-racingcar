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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("1,1,2,3이 추가되면 Set의 크기가 3이어야 한다.")
    void size() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("1,1,2,3이 추가되면 Set에 1,2,3의 값이 존재해야한다.")
    void contains_pass(int input) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("1,1,2,3이 추가되면 Set에 1,2,3의 값은 존재하고, 4,5는 존재하지 않는다.")
    void contains_fail(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}