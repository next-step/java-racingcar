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
    @DisplayName("Set Collection 의 size 메소드 테스트")
    void setSize() {
        int expectedValue = 3;

        assertThat(numbers.size()).isEqualTo(expectedValue);
    }

    @DisplayName("JUnit 의 ParameterizedTest 학습")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource({"1,True", "2,True", "3,True", "4,False", "5,False"})
    void csvSource(String input, String expected) {
        // given
        boolean expectedValue = Boolean.parseBoolean(expected);
        Integer inputValue = Integer.parseInt(input);

        // when
        boolean result = numbers.contains(inputValue);

        // then
        assertThat(result).isEqualTo(expectedValue);
    }
}
