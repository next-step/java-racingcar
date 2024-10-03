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

    @DisplayName("자동차 이름 입력 시 쉼표가 아닌 구분자를 사용할 경우 예외가 발생한다.")
    @Test
    void delimiterPatternCheckTest() {
        String userInput = "pobi,crong.honux";
        String defaultDelimiter = ",";

        Assertions.assertThatThrownBy(() -> UserInputValidator.carNamesInputValidate(userInput, defaultDelimiter))
                .isInstanceOf(GameException.class)
                .hasMessage("자동차 이름을 올바르게 쉼표(,)로 구분하여 입력해주세요.");
    }

    @DisplayName("길이 5를 넘는 자동차 이름을 입력할 경우 예외가 발생한다.")
    @Test
    void validateNameLengthTest() {
        String userInput = "podfdfbi,crdfdfdong,hodfdfnux";
        String defaultDelimiter = ",";

        Assertions.assertThatThrownBy(() -> UserInputValidator.carNamesInputValidate(userInput, defaultDelimiter))
                .isInstanceOf(GameException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름을 중복 입력할 경우 예외가 발생한다.")
    @Test
    void duplicatedNamesCheck() {
        String userInput = "pobi,crong,pobi,honux";
        String defaultDelimiter = ",";

        Assertions.assertThatThrownBy(() -> UserInputValidator.carNamesInputValidate(userInput, defaultDelimiter))
                .isInstanceOf(GameException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }




}