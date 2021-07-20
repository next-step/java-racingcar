package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("숫자2개를 더하면 뎃셈기능이 발생된다.")
    public void calculate_plus() {
        String checkValue = "2 + 4";
        int resultValue = stringCalculator.calculate(checkValue);

        assertThat(resultValue).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자2개를 빼면 뺄셈기능이 발생된다.")
    public void calculate_minus() {
        String checkValue = "4 - 1";
        int resultValue = stringCalculator.calculate(checkValue);

        assertThat(resultValue).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자2개 곱하면 곱셈기능이 발생된다.")
    public void calculate_multiple() {
        String checkValue = "3 * 5";
        int resultValue = stringCalculator.calculate(checkValue);

        assertThat(resultValue).isEqualTo(15);
    }

    @Test
    @DisplayName("숫자2개를 나누면 나눗셈기능이 발생된다.")
    public void calculate_divide() {
        String checkValue = "15 / 3";
        int resultValue = stringCalculator.calculate(checkValue);

        assertThat(resultValue).isEqualTo(5);
    }

    @Test
    @DisplayName("나누셈의 2번째 숫자에0을 넣으면 예외가 발생된다.")
    public void calculate_divideByZero() {
        String checkValue = "15 / 0";
        assertThatThrownBy(() -> stringCalculator.calculate(checkValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눗셈은 불가능 합니다.");
    }

    @Test
    @DisplayName("연산기호에 빈값을 넣으면 예외가발생된다.")
    public void calculate_expression_empty_check() {
        String checkValue = "2  3 +  + 1 / 2";

        assertThatThrownBy(() -> stringCalculator.calculate(checkValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산 수식이 빈값입니다.");
    }

    @Test
    @DisplayName("연산기호가 아닌 다른 문자열을 넣으면 예외가 발생된다.")
    public void calculate_notExpression_check() {
        String checkValue = "2 ) 3 + 1 / 2";

        assertThatThrownBy(() -> stringCalculator.calculate(checkValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산자가 아닙니다.");
    }

    @Test
    @DisplayName("연산되는 문자배열길이가 3이하이면 예외가 발생된다.")
    public void calculate_arraySize_check() {
        String checkValue = "2 +";

        assertThatThrownBy(() -> stringCalculator.calculate(checkValue))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("배열의 길이는 최소 3이상 이어야 합니다.");
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 기능읗 넣으면 모든 사칙연산에 대하여 계산된다.")
    public void calculator_operate_check() {
        String checkValue = "1 + 2 * 5 / 3";
        int result = stringCalculator.calculate(checkValue);
        assertThat(result).isEqualTo(5);
    }

}