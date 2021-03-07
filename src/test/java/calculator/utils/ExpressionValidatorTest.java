package calculator.utils;

import calculator.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class ExpressionValidatorTest {

    @Test
    @DisplayName("입력 값 Null일 경우 에러")
    public void validateNull() throws Exception {
        //given
        String expression = null;

        //when

        //then
        assertThatNullPointerException().isThrownBy(() -> new Expression(expression));
    }

    @Test
    @DisplayName("입력 값 빈 공백 문자일일 경우 에러")
    public void validateEmpty() throws Exception {
        //given
        String expression = "     ";

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(expression));
    }

    @ParameterizedTest(name = "{0}의 길이는 3 미만")
    @ValueSource(strings = {"3 + ", "- - ", "/ ", "+ 56"})
    @DisplayName("분리된 값 길이 3 미만일 경우 에러")
    public void validateMinimumLength(String expression) throws Exception {
        //given

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(expression));
    }

    @ParameterizedTest(name = "{0}의 길이는 짝수")
    @ValueSource(strings = {"1 + 2 /", "1 - 2 / 3 +", "6 + 2 / 3 * 6 + 8 -"})
    @DisplayName("분리된 값의 길이가 짝수일 경우 에러")
    public void validateOddLength(String expression) throws Exception {
        //given

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(expression));
    }
}