package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputValidatorTest {

    @DisplayName("자동차 이름에 입력된 값이 공백일 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {",,", ",,,", ""})
    void validateEmptyFromCarNames(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(EmptyAndNullSourceException.class);
    }

    @DisplayName("자동차 이름에 입력된 값이 숫자일 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"3", "54", "2", "52"})
    void validateNumericFromCarNames(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(NumericException.class);
    }

    @DisplayName("자동차 이름에 입력된 이름길이가 5자를 초과할 경우 예외발생")
    @Test
    void validateLengthFromCarNames() {
        String input = "pobi,crong,honux,hystrix";

        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(OverNameLengthException.class);
    }

    @DisplayName("입력된 값이 null혹은, 빈값일 경우 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String input) {
        assertAll(
                () -> assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                        .isInstanceOf(EmptyAndNullSourceException.class),
                () -> assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                        .isInstanceOf(EmptyAndNullSourceException.class)
        );

    }

    @DisplayName("시도회수에 입력값이 0일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = "0")
    void validateZeroFromAttempts(String input) {
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(ZeroStringException.class);
    }

    @DisplayName("시도회수에 입력값이 일반 문자열일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"문자열1", "입력값입니다.", "잘못 입력했어요.", "숫자가 아닙니다."})
    void validateStringFromAttempts(String input) {
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(InvalidInputException.class);
    }
}