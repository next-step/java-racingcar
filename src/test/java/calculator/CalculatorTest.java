package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculatorTest {
    private Calculator calculator;

    @DisplayName("주어진 문자열에 있는 연산자 중 사칙 연산자는 계산할 수 있다.")
    @Test
    void getOperatorTest() {
        assertAll(
                () -> assertThat(Operator.getOperator("+")).isEqualTo(Operator.ADDITION),
                () -> assertThat(Operator.getOperator("-")).isEqualTo(Operator.SUBTRACTION),
                () -> assertThat(Operator.getOperator("*")).isEqualTo(Operator.MULTIPLICATION),
                () -> assertThat(Operator.getOperator("/")).isEqualTo(Operator.DIVISION)
        );
    }

    @DisplayName("주어진 문자열에 있는 연산자 중 사칙 연산자를 제외한 연산자는 계산할 수 없다.")
    @Test
    void notArithmeticOperatorsException() {
        String expression = "2 % 3";
        calculator = new Calculator(expression);

        assertThatThrownBy(() -> calculator.calculate()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 수 없다.")
    @Test
    void EmptyStringException() {
        assertThatThrownBy(() -> {
            String expression = "";
            calculator = new Calculator(expression);

            calculator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 수 없다.")
    @Test
    void NullException() {
        assertThatThrownBy(() -> {
            String expression = null;
            calculator = new Calculator(expression);

            calculator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 계산기는 입력값에 따른 계산 순서로 계산할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "2 * 3 / 3,2", "-14 / 2,-7"
    })
    void calculateExpression(String input, int expected) {
        calculator = new Calculator(input);

        assertThat(calculator.calculate()).isEqualTo(expected);
    }
}
