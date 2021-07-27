package com.racingcar.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @DisplayName("입력 값에 있는 연산 식이 완료되지 않을 때 테스트")
    public void inputValueIsNotCompleted() {
        //given
        String given = "2 + 1 -";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(given));
    }

    @Test
    @DisplayName("입력 값의 숫자 부분에 유효하지 않는 형식 들어 갔을 때 테스트")
    public void inputSomeValuesIsNotNumberFormat() {
        //given
        String given = "2 + 1 - ?";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(given));
    }

    @ParameterizedTest
    @DisplayName("모든 올바른 경우 테스트")
    @CsvSource({"3 + 2 - 1 * 10,40", "12 / 3 - 2 * 6,12", "6 / 2 + 3 - 1 * 4,20"})
    public void allCorrectCase(String input, int expected) {
        //when
        int result = StringCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
