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
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size() {
        int expected = 3;
        int size = numbers.size();
        assertThat(size).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    void contains1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains()를 실행했을 때, 1, 2, 3은 true, 4, 5는 넣으면 false를 반환한다.")
    void contains2(String input, String expected) {
        int inputValue = Integer.parseInt(input);
        boolean expectedValue = Boolean.parseBoolean(expected);
        assertThat(numbers.contains(inputValue)).isEqualTo(expectedValue);
    }
}