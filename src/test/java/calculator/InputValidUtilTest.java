package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputValidUtilTest {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private static final String SPACE = " ";

    @Test
    @DisplayName("입력값이 null 일때 예외처리 테스트")
    public void inputIsNull() {
        // given
        String input = null;

        // when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidUtil.isNull(input))
                .withMessageMatching(WRONG_INPUT);
    }

    @Test
    @DisplayName("입력값이 공백만 있을때 예외처리 테스트")
    public void inputIsSpace() {
        // given
        String input = "     ";

        // when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidUtil.numbersValidation(input.split(SPACE)))
                .withMessageMatching(WRONG_INPUT);
    }

    @Test
    @DisplayName("입력값이 처리 불가능할때 예외처리 테스트")
    public void inputIsNotAble() {
        // given
        String input = "2 + 4 - * 2";

        // when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidUtil.numbersValidation(input.split(SPACE)))
                .withMessageMatching(WRONG_INPUT);
    }

}