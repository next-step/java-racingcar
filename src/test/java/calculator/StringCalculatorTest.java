package calculator;

import calculator.enums.Operator;
import calculator.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("덧셈")
    public void add() throws Exception {
        //given
        String expression = "5 + 5 + 10";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("뺼셈")
    public void subtract() throws Exception {
        //given
        String expression = "5 - 100 - 20";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(-115);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() throws Exception {
        //given
        String expression = "5 * 100 * 20";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(10000);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() throws Exception {
        //given
        String expression = "100 / 20 / 2";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("올바르지 않은 사칙 연산")
    public void validateSymbol() throws Exception {
        //given
        String expression = "10 ^ 20 / 2";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringCalculator.calculate(splitExpression));
    }
}