package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("문자열 계산기는 \"1+3\"을 입력받아 4를 반환해야 한다")
    @Test
    void calculatorWorks() {
        int sum = calculator.calculate("1+3");
        assertThat(sum).isEqualTo(4);
    }

    @DisplayName("문자열 계산기는 덧셈을 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1+3=4", "3+3=6", "1+1+1=3", "5+4+3=12"}, delimiter = '=')
    void calculatorCanSum(String expression, int expected) {
        int sum = calculator.calculate(expression);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("문자열 계산기는 사칙연산을 함께 수행할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1+3-3=1", "4/2+3*2=10", "5-3+1*3+2=11", "5+4-3=6", "3-7=-4", "1*0*0=0"}, delimiter = '=')
    void calculatorCanOperationsZ(String expression, int expected) {
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("첫번째 숫자가 음수인 경우에도 사칙연산을 수행할 수 있다")
    @Test
    void calculatorWorksWithNegativeNumbers() {
        int result = calculator.calculate("-3+2");
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("0으로 나누어지는 경우 ArithmeticException 을 throw 한다")
    @Test
    void throwExceptionIfDividedByZero() {
        assertThatThrownBy(() -> {
            calculator.calculate("3/0");
        }).isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException 을 throw 한다")
    @Test
    void throwExceptionIfNullOfEmptyInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("");
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 을 throw 한다")
    @Test
    void throwExceptionIfUnknownOperation() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("3+4$3");
        });
    }
}