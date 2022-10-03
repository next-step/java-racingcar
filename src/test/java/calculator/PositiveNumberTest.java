package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void invalidNumber(int invalidNumber) {
        assertThatThrownBy(() -> new PositiveNumber(invalidNumber)).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void validNumber(int validNumber) {
        assertThat(new PositiveNumber(validNumber)).isEqualTo(new PositiveNumber(validNumber));
        assertThat(new PositiveNumber(validNumber)).isNotSameAs(new PositiveNumber(validNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:1:3", "5:10:15", "10:5:15"}, delimiter = ':')
    void plus(int number1, int number2, int expected) {
        PositiveNumber positiveNumber1 = new PositiveNumber(number1);

        assertThat(positiveNumber1.plus(new PositiveNumber(number2)))
            .isEqualTo(new PositiveNumber(expected));

        // assert that PositiveNumber object is immutable even after add operation
        assertThat(positiveNumber1).isEqualTo(new PositiveNumber(number1));
    }
}