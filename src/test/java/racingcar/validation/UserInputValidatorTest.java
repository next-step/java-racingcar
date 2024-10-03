package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.GameException;

class UserInputValidatorTest {

    @DisplayName("입력값이 빈값인 경우 예외가 발생한다.")
    @Test
    void emptyInputTest() {
        String userInput = "";

        Assertions.assertThatThrownBy(() -> UserInputValidator.numberInputValidate(userInput))
                .isInstanceOf(GameException.class)
                .hasMessage("올바른 입력값이 아닙니다.");
    }

    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void wrongNumberFormatInputTest() {
        String userInput = "abcd";

        Assertions.assertThatThrownBy(() -> UserInputValidator.numberInputValidate(userInput))
                .isInstanceOf(GameException.class)
                .hasMessage("숫자만 가능합니다.");
    }

    @DisplayName("입력값이 음수인 경우 예외가 발생한다.")
    @Test
    void negativeNumberTest() {
        String userInput = "-1";

        Assertions.assertThatThrownBy(() -> UserInputValidator.numberInputValidate(userInput))
                .isInstanceOf(GameException.class)
                .hasMessage("양수를 입력해주세요.");
    }
}