package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Set 의 크기는 중복을 제외한 값이다.")
    void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 은 1,2,3 값을 포함하고 있다.")
    @ParameterizedTest(name = "Input : {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("1,2,3 은 true 를 반환하고, 나머지는 false 를 반환한다.")
    @ParameterizedTest(name = "Input : {0}  expected : {1}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void containsTrueOrFalse(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
