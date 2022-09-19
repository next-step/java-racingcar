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
    @DisplayName("요구사항 1 : set size")
    void check_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2 : ParameterizedTest 활용")
    @ValueSource(ints = {1, 2, 3})
    void parameterized(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항 3 : ParameterizedTest, CsvSource 를 활용해 true, false 확인")
    @CsvSource(value = {"1:true", "2:true", "4:false", "5:false"}, delimiter = ':')
    void parameterized_csv(String input, String expected) {
        // given
        int number = Integer.parseInt(input);
        boolean aBoolean = Boolean.parseBoolean(expected);

        // expected
        assertThat(numbers.contains(number)).isEqualTo(aBoolean);
    }
}
