package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "    ", "\t", "\n"})
    void null_or_blank(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"3,3", "1,1", "2,2"})
    void singleton(String input, int number) {
        assertThat(Calculator.calculate(input)).isEqualTo(number);

    }

    @ParameterizedTest
    @CsvSource({"1 + 2,3", "3 * 4,12", "6 / 3,2"})
    void binary_operation(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    void mixed_operations() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
