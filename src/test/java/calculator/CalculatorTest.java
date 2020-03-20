package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("피연산자가 숫자인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "29", "10000", "2222"})
    public void validateOperand1(String operand) throws Exception {
        //then
        Calculator.validateOperand(operand);
    }

    @DisplayName("피연산자가 숫자인지 체크 - fail 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1ㅁ", "2d", "d", "-", "29`", "100~00", "^"})
    public void validateOperand2(String operand) throws Exception {
        //then
        assertThatThrownBy(() -> {
            Calculator.validateOperand(operand);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    public void validateOperator1(String operator) throws Exception {
        //then
        Calculator.validateOperator(operator);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"++", "/-", "--", "***", "1", "ㅁ", "a"})
    public void validateOperator2(String operator) throws Exception {
        //then
        assertThatThrownBy(() -> {
            Calculator.validateOperator(operator);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * input 2개와 결과값 1개 총 3개가 필요함
     * CsvSource 를 이용할 경우 delimiter로 2개의 값으로 분리가 가능한데
     * 3개의 값을 자동으로 테스트 하는 방법은 없을까요?
     */
    @DisplayName("덧셈 테스트")
    @Test
    public void plus() throws Exception {
        assertThat(Calculator.plus(1, 2)).isEqualTo(3);
        assertThat(Calculator.plus(1, 2)).isNotEqualTo(2);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    public void minus() throws Exception {
        assertThat(Calculator.minus(3, 2)).isEqualTo(1);
        assertThat(Calculator.minus(3, 2)).isNotEqualTo(2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    public void multiplication() throws Exception {
        assertThat(Calculator.multiplication(3, 2)).isEqualTo(6);
        assertThat(Calculator.multiplication(3, 2)).isNotEqualTo(7);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    public void division() throws Exception {
        assertThat(Calculator.division(4, 2)).isEqualTo(2);
        assertThat(Calculator.division(4, 2)).isNotEqualTo(3);
    }

    @DisplayName("사칙연산 테스트")
    @Test
    public void calculate() throws Exception {
        //given
        double num1 = 1;
        double num2 = 2;
        double num4 = 4;

        //when

        //then
        assertThat(Calculator.calculate(num1, num2, "+")).isEqualTo(3);
        assertThat(Calculator.calculate(num1, num2, "-")).isEqualTo(-1);
        assertThat(Calculator.calculate(num2, num2, "*")).isEqualTo(4);
        assertThat(Calculator.calculate(num2, num2, "/")).isEqualTo(1);
        assertThat(Calculator.calculate(num2, num2, "+")).isNotEqualTo(1);
        assertThat(Calculator.calculate(num2, num2, "_")).isNotEqualTo(1);
        assertThat(Calculator.calculate(num2, num2, "*")).isNotEqualTo(1);
        assertThat(Calculator.calculate(num2, num2, "/")).isNotEqualTo(2);
    }

    @DisplayName("사용자의 input을 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 3:6", "5 / 2:2.5", "2 * 3 / 2:3", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    public void calculateUserInput(String input, double expect) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();
        Calculator calculator = new Calculator(inputSplit);

        //when
        double result = calculator.calculateUserInput();

        //then
        assertThat(result).isEqualTo(expect);
    }
}