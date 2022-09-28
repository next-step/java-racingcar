package calculator.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:2:4", "3:0:3"}, delimiter = ':')
    public void sum_합산_검증(int num1, int num2, int expected) {
        PositiveNumber result = new PositiveNumber(num1);

        result.plus(new PositiveNumber(num2));

        assertThat(result).isEqualTo(new PositiveNumber(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1})
    public void validateRange_negative_(int value) {
        assertThatThrownBy(() -> new PositiveNumber(value))
                .isInstanceOf(OutOfRangeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1"}, delimiter = ':')
    public void stringToInt_검증(String value, int expected) {
        PositiveNumber result = PositiveNumber.stringToInt(value);
        assertThat(result).isEqualTo(new PositiveNumber(expected));
    }
}