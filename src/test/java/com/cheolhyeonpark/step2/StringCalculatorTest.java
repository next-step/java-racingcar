package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("문자열로 이루어진 수식이 입력되면 정수 해답을 출력한다")
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "5 * 5 * 5, 125", "5 - 10 * 4 / 2, -10"})
    public void calculateStringExpression(String input, int answer) {
        //given
        String expression = input;

        //when
        int result = stringCalculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(answer);
    }
}