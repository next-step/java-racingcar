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
    }

    @DisplayName("요구사항 1. Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    @Test
    void test1() {
        // then
        Assertions.assertThat(numbers)
                .hasSize(3);
    }

    @DisplayName("요구사항 2. Set의 contains() 메소드를 활용해 특정 값이 존재하는지를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int number) {
        // then
        Assertions.assertThat(numbers.contains(number))
                .isTrue();
    }

    @DisplayName("요구사항 3. Set의 contains() 메소드를 활용해 특정 값이 존재하지 않는지도 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "4:false", "5:false"}, delimiter = ':')
    void test3(int input, boolean expected) {
        // then
        Assertions.assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}
