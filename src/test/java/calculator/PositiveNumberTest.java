package calculator;

import static calculator.PositiveNumber.NOT_NUMBER_EXCEPTION;
import static calculator.PositiveNumber.NOT_POSITIVE_NUMBER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {
    @ParameterizedTest
    @DisplayName("음수가 들어오면 예외를 던집니다.")
    @ValueSource(strings = {"-1", "-2", "-110"})
    void create_positive_number_error_by_negative_number(String given) {
        // when // then
        assertThatThrownBy(() -> new PositiveNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값이 들어오면 예외를 던집니다.")
    @ValueSource(strings = {"가나", "suzhanlee", "-*(10)"})
    void create_positive_number_error_by_not_number(String given) {
        // when // then
        assertThatThrownBy(() -> new PositiveNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_EXCEPTION);
    }

    @Test
    @DisplayName("양수 값 객체 끼리 더할 수 있다.")
    void plus() {
        // given
        PositiveNumber number = new PositiveNumber("4");

        // when
        PositiveNumber result = number.plus(new PositiveNumber("3"));

        // then
        assertThat(result).isEqualTo(new PositiveNumber("7"));
    }
}
