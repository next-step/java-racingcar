package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.exception.EmptyAndNullSourceException;
import racinggame.exception.InvalidInputException;
import racinggame.exception.ZeroStringException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilsTest {

    @DisplayName("입력값이 공백이 있을경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "이름1,이름2 | ''",
            "'' | 3"
    }, delimiter = '|')
    void validateEmptySource(String carNames, String numberOfAttempts) {
        assertThatThrownBy(
                () -> InputUtils.convertInputValue(carNames, numberOfAttempts))
                .isInstanceOf(EmptyAndNullSourceException.class);
    }

    @DisplayName("시도값이 문자열이 있을경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "이름1,이름2 | '문자열입니다.'",
            "이름1, | 문자열입니다2"
    }, delimiter = '|')
    void validateString(String carNames, String numberOfAttempts) {
        assertThatThrownBy(
                () -> InputUtils.convertInputValue(carNames, numberOfAttempts))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("입력한 값이 0이 있을경우 예외 발생")
    @Test
    void validateZero() {
        String carNames = "pobi,crong,honux,hystr";
        String attempts = "0";

        assertThatThrownBy(
                () -> InputUtils.convertInputValue(carNames, attempts))
                .isInstanceOf(ZeroStringException.class);
    }
}