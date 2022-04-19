package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputStringValidatorTest {

    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";

    @ParameterizedTest
    @DisplayName("입력값 내용 오류 기능 테스트")
    @ValueSource(strings = {"19", "*:!!", "23~", "-189", "25"})
    void validTest(String input) {
        assertThatThrownBy(() -> {
            InputStringValidator.valid(input);
        }).hasMessageContaining(WRONG_INPUT_ERROR_MESSAGE);
    }
}