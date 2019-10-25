package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "2 + 5 - 10 * -2:6",
            "3 + 3 / 2:3"
    }, delimiter = ':')
    void run(String input, Integer result) {
        assertThat(Calculator.run(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "6 * *",
            "3 + 3 2",
            "3 & 3"
    })
    void throwError(String input) {
        assertThatThrownBy(() -> Calculator.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}