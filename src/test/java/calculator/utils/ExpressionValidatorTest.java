package calculator.utils;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidatorTest {

    @Test
    @DisplayName("입력 값 Null일 경우 에러")
    public void validateNull() throws Exception {
        //given
        String[] splitExpression = null;

        //when
        StringCalculator stringCalculator = new StringCalculator();

        //then
        assertThatNullPointerException().isThrownBy(() -> stringCalculator.calculate(splitExpression));
    }

    @Test
    @DisplayName("입력 값 빈 공백 문자일일 경우 에러")
    public void validateEmpty() throws Exception {
        //given
        String expression = "     ";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(splitExpression));
    }

    @Test
    @DisplayName("분리된 값 길이 3 미만일 경우 에러")
    public void validateLength() throws Exception {
        //given
        String expression = "3 + ";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(splitExpression));
    }
}