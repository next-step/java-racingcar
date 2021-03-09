package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("입력값이 Null일 경우 에러")
    public void validateNull() throws Exception {
        //given
        String input = null;

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateNull(input));
    }

    @Test
    @DisplayName("입력값이 비어있을 경우 에러")
    void validateEmpty() {
        //given
        String input = "";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateEmpty(input));
    }

    @ParameterizedTest(name = "{0} <= 0")
    @ValueSource(strings = {"-1023", "0", "-463", "-6854"})
    @DisplayName("입력값이 0보다 같거나 작을 경우 에러")
    void validateLessThanZero(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateLessThanZero(number));
    }
}