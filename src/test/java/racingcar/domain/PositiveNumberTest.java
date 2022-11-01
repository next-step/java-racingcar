package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    // TODO
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void invalidNumber(final int invalidNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PositiveNumber(invalidNumber))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-5", "-10", "A", "a", "O"})
    void invalidString(final String invalidString) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PositiveNumber(invalidString))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void validNumber(final int validNumber) {
        assertThat(new PositiveNumber(validNumber)).isEqualTo(new PositiveNumber(validNumber));
        assertThat(new PositiveNumber(validNumber)).isNotSameAs(new PositiveNumber(validNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void validString(final String validString) {
        assertThat(new PositiveNumber(validString)).isEqualTo(new PositiveNumber(validString));
        assertThat(new PositiveNumber(validString)).isNotSameAs(new PositiveNumber(validString));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:1:3", "5:10:15", "10:5:15"}, delimiter = ':')
    void plus(final int number1, final int number2, final int expected) {
        final PositiveNumber positiveNumber1 = new PositiveNumber(number1);

        assertThat(positiveNumber1.plus(new PositiveNumber(number2)))
            .isEqualTo(new PositiveNumber(expected));

        // assert that PositiveNumber object is immutable even after add operation
        assertThat(positiveNumber1).isEqualTo(new PositiveNumber(number1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void isGreaterThan_sameValue(final int value) {
        assertThat(new PositiveNumber(value).isGreaterThan(new PositiveNumber(value)))
            .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10"}, delimiter = ':')
    void isGreaterThan(final int smallerValue, final int value) {
        assertThat(new PositiveNumber(value).isGreaterThan(new PositiveNumber(smallerValue)))
            .isTrue();
        assertThat(new PositiveNumber(smallerValue).isGreaterThan(new PositiveNumber(value)))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void isLessThanOrEquals_sameValue(final int value) {
        assertThat(new PositiveNumber(value).isLessThanOrEquals(new PositiveNumber(value)))
            .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10"}, delimiter = ':')
    void isLessThanOrEquals(final int smallerValue, final int value) {
        assertThat(new PositiveNumber(smallerValue).isLessThanOrEquals(new PositiveNumber(value)))
            .isTrue();
        assertThat(new PositiveNumber(value).isLessThanOrEquals(new PositiveNumber(smallerValue)))
            .isFalse();
    }
}
