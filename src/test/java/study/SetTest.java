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

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("numbers의 크기를 반환한다.")
    @Test
    void check_size_when_call_method_size_from_Set() {
        int result = numbers.size();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("numbers기 값을 포함하고 있으면 True를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void return_true_when_numbers_contains_value(int given) {
        boolean result = numbers.contains(given);

        assertThat(result).isTrue();
    }

    @DisplayName("numbers기 값을 포함하고 있으면 True, 반대는 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void return_boolean_depending_on_containing_value(int given, boolean expected) {
        boolean result = numbers.contains(given);

        assertThat(result).isEqualTo(expected);
    }

}
