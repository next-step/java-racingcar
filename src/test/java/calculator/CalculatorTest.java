package calculator;

import calculator.domain.CalculatorCore;
import calculator.domain.CalculatorOperator;
import calculator.domain.CalculatorView;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        int result = CalculatorCore.calculate(2, "+", "3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 곱셈() {
        int result = CalculatorCore.calculate(2, "*", "3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 뺄셈() {
        int result = CalculatorCore.calculate(5, "-", "3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 나눗셈() {
        int result = CalculatorCore.calculate(6, "/", "3");
        assertThat(result).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void 나눗셈에러() {
        int result = CalculatorCore.calculate(10 , "/", "0");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 복합연산() {
        String[] input = {"2", "+", "3", "*", "4", "/", "2"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 여러자리수_복합연산() {
        String[] input = {"200", "+", "30", "/", "10", "-", "3"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void 추가연산자테스트() {
        String[] input = {"1", "p", "2", "+", "3", "-", "4"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void 없는연산자테스트() {
        String[] input = {"1", "a", "2", "+", "3", "-", "4"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 연산자_enum_테스트() {
        int result = CalculatorOperator.ADD.calculate(10, 20);
        assertThat(result).isEqualTo(30);
        result = CalculatorOperator.SUBTRACT.calculate(5, 2);
        assertThat(result).isEqualTo(3);
        result = CalculatorOperator.MULTIPLICATION.calculate(4, 8);
        assertThat(result).isEqualTo(32);
        result = CalculatorOperator.DIVISION.calculate(9, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getEnumName_테스트() {
        CalculatorOperator calculatorOperator = CalculatorOperator.getEnumNameByString("+");
        assertThat(calculatorOperator).isEqualTo(CalculatorOperator.ADD);
        calculatorOperator = CalculatorOperator.getEnumNameByString("p");
        assertThat(calculatorOperator).isEqualTo(CalculatorOperator.ADD2);
        calculatorOperator = CalculatorOperator.getEnumNameByString("*");
        assertThat(calculatorOperator).isEqualTo(CalculatorOperator.MULTIPLICATION);
        calculatorOperator = CalculatorOperator.getEnumNameByString("-");
        assertThat(calculatorOperator).isEqualTo(CalculatorOperator.SUBTRACT);
        calculatorOperator = CalculatorOperator.getEnumNameByString("/");
        assertThat(calculatorOperator).isEqualTo(CalculatorOperator.DIVISION);
    }

    @Test
    public void 정규식() {
        boolean result = CalculatorView.patternMatcher("2 + 3");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("2 + 3 * 4 / 2");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("2 + 30 * 4 / 2");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("200 + 3 * 4 + 20");
        assertThat(result).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result = CalculatorView.patternMatcher("2 +3 * 4 / 2");
        assertThat(result).isFalse();
        result = CalculatorView.patternMatcher("2 + 3 * 4 / ");
        assertThat(result).isFalse();
        result = CalculatorView.patternMatcher(" + 3 * 4 / 2");
        assertThat(result).isFalse();
    }

}