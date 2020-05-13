package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("문자열로 이루어진 수식이 입력되면 정수 해답을 출력")
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "5 * 5 * 5, 125", "5 - 10 * 4 / 2, -10", "5/5+1-2, 0", "11*10/11, 10"})
    public void calculateStringExpression(String input, int answer) {
        //given
        String expression = input;

        //when
        int result = stringCalculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("입력값이 Null이면 예외를 출력")
    public void throwIllegalArgumentExceptionWhenThereIsNoInput() {
        // given
        String expression = null;

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(expression));
    }

    @Test
    @DisplayName("입력값이 공백이면 예외를 출력")
    public void throwIllegalArgumentExceptionWhenInputIsBlank() {
        // given
        String expression = " ";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(expression));
    }

    @Test
    @DisplayName("0으로 나누면 예외를 출력")
    public void throwIllegalArgumentExceptionWhenDividedByZero() {
        // given
        String expression = "1/0";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(expression));
    }

    @Test
    @DisplayName("사칙연산 연산자가 아니면 예외를 출력")
    public void throwIllegalArgumentExceptionWhenUsedWrongOperator() {
        // given
        String expression = "5^5";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(expression));
    }

    @Test
    @DisplayName("숫자가 아니면 예외를 출력")
    public void throwIllegalArgumentExceptionWhenUsedNotNumber() {
        // given
        String expression = "a*b";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(expression));
    }
}