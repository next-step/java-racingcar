package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.PositiveNumber.NOT_NUMBER_EXCEPTION;
import static racingcar.domain.PositiveNumber.NOT_POSITIVE_NUMBER_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {

    @ParameterizedTest
    @DisplayName("값이 숫자 인지 검증한다.")
    @ValueSource(strings = {"가자", "suzhanlee", "%^&", "-121가3"})
    void validate_number(String given) {
        // when // then
        assertThatThrownBy(() -> new PositiveNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("숫자가 양수 인지 검증한다.")
    @ValueSource(strings = {"-1", "-2", "-3", "-1213"})
    void validate_positive_number(String given) {
        // when // then
        assertThatThrownBy(() -> new PositiveNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_NUMBER_EXCEPTION);
    }
}
