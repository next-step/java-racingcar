package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열 사칙 연산 계산기 테스트")
public class CalculatorTest {

    @DisplayName("덧셈, 뺄셈, 곱셈, 나눗셈 기능이 각각 정상 동작한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 + 7 + 1=11", "11 - 2 - 3=6", "3 * 6 * 9=162", "12 / 2 / 3=2"}, delimiter = '=')
    void eachOperatorTest(String numericExpression, int result) {
        // when, then
        assertEquals(Calculator.calculate(numericExpression), result);
    }

    @DisplayName("입력 문자열이 null이면 Exception이 발생한다.")
    @Test
    void nullExceptionTest() {
        // given
        String numericExpression = null;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(numericExpression))
                .withMessage("수식이 존재하지 않습니다.");
    }

    @DisplayName("입력 문자열이 빈 공백이면 Exception이 발생한다.")
    @Test
    void blankExceptionTest() {
        // given
        String numericExpression = " ";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(numericExpression))
                .withMessage("수식이 존재하지 않습니다.");
    }

    @DisplayName("0으로 나누면 Exception이 발생한다.")
    @Test
    void zeroDivisionExceptionTest() {
        // given
        String numericExpression = "3 / 0";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(numericExpression))
                .withMessage("0으로 나눌 수 없습니다.");
    }

    @DisplayName("사칙연산 기호가 아닐 경우 Exception이 발생한다.")
    @Test
    void invalidSignExceptionTest() {
        // given
        String numericExpression = "3 ^ 1";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(numericExpression))
                .withMessage("존재하지 않는 부호입니다. (sign: ^)");
    }

    @DisplayName("모든 사칙연산이 들어간 문자열에 대해 계산기가 정상 동작한다.")
    @Test
    void operationTest() {
        // given
        String numericExpression = "2 + 3 * 4 / 2";

        // when
        int result = Calculator.calculate(numericExpression);

        // then
        assertEquals(result, 10);
    }
}
