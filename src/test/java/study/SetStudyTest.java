package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetStudyTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("Set의 contains() 메소드의 입력 값에 따라 결과 값이 다른 경우")
    void contains_ShouldReturnTrueOrFalseForInputs(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
