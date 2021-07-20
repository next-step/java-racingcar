package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @Test
    @DisplayName("(validate) 유저가 올바른 입력을 행할 경우, 어떠한 에러도 일어나지 않는다.")
    void validate_correct_args() {
        String userInput = "1 + 2";

        assertThatCode(() -> {
            UserInputValidator.validate(userInput);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("(validate) 유저의 입력이 null일때, 예외를 던진다.")
    void validate_args_is_null() {
        String userInput = null;

        assertThatThrownBy(() -> {
            UserInputValidator.validate(userInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("유저로부터 입력이 전혀 없습니다.");
    }


    @Test
    @DisplayName("(validate) 유저의 입력이 공백문자일때, 예외를 던진다.")
    void validate_args_is_emtpy_string() {
        String userInput = "       ";

        assertThatThrownBy(() -> {
            UserInputValidator.validate(userInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("공백문자만으로는 연산을 수행할 수 없습니다.");
    }

}