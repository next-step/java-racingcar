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

    // Test Case 구현
    @DisplayName("Set.size(): Set의 크기를 확인할 수 있다.")
    @Test
    void set_size() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set.contains(): (1) Set에 값이 존재하는지 확인한다.")
    @ParameterizedTest(name = "{0} : Set에 존재한다")
    @ValueSource(ints  = {1,2,3})
    void set_parameterized_1(int number) {
        assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers).contains(number);
    }

    @DisplayName("Set.contains(): (2) Set에 값이 존재하는지 확인한다.")
    @ParameterizedTest(name = "{0} : Set에 존재 ? {1}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void set_parameterized_2(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
