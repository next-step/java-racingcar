package com.racingcar.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    public void add() {
        //given
        String given = "5 + 3";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtract() {
        //given
        String given = "5 - 3";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    public void divide() {
        //given
        String given = "21 / 7";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 테스트")
    public void multiply() {
        //given
        String given = "3 * 7";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("복합 연산 테스트")
    public void multiCalculateTest() {
        //given
        String given = "2 + 3 * 4 / 2";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 값 null 일 때 테스트")
    public void inputValueIsNull() {
        //given
        String given = null;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(given));
    }
}
