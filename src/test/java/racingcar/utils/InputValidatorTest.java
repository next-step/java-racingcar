package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @ParameterizedTest(name = "{0}은 정수가 아니다.")
    @ValueSource(strings = {"a", "b", "c", "d", "e"})
    @DisplayName("입력값이 정수가 아닐 경우 에러")
    public void validateInteger(String input) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateInteger(input));
    }
}