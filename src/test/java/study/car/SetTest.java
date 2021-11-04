package study.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("1단계 - Set Collection 학습 테스트")
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
    @DisplayName("요구사항 1 - Set size 확인")
    void size() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2 - ParameterizedTest - contains 활용한 1, 2, 3 값 존재 확인")
    void contains(int value) {
        assertThat(numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("요구사항 3 - ParameterizedTest - true, false 경우 동시 확인")
    void containsTrueFalseCases(String actual, String expected) {
        int parsedActual = Integer.parseInt(actual);
        boolean parsedExpected = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(parsedActual))
                .isEqualTo(parsedExpected);
    }
}
