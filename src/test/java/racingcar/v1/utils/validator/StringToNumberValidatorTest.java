package racingcar.v1.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringToNumberValidatorTest {

    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";

    private static final Validator<Integer, String> validator = new StringToNumberValidator();

    @ParameterizedTest
    @DisplayName("입력값 내용 오류 기능 테스트")
    @ValueSource(strings = {"1^", "**$", "25@","21@5"})
    void wrongInputValidTest(String input) {

        assertThatThrownBy(() -> {
            validator.valid(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_INPUT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("입력값 내용 정상 입력 기능 테스트")
    @ValueSource(strings = {"15", "25", "254","215"})
    void rightInputValidTest(String input) {

        assertThat(validator.valid(input)).isEqualTo(Integer.parseInt(input));
    }
}