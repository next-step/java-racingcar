package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("2 + 3 * 4 / 2 가 입력되면 10을 출력한다")
    public void calculateStringExpression() {
        //given
        String givenString = "2 + 3 * 4 / 2";

        //when
        int answer = stringCalculator.carculate(givenString);

        //then
        assertThat(answer).isEqualTo(10);
    }
}