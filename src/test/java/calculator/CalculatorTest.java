package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculatorTest {

    @Test
    void 계산기_덧셈_기능을_테스트한다() {
        //given
        BigInteger num1 = BigInteger.TEN;
        BigInteger num2 = new BigInteger("20");

        //when
        BigInteger actual = Calculator.add(num1, num2);

        //then
        assertThat(actual).isEqualTo(30);
    }

    @Test
    void 계산기_뺄셈_기능을_테스트한다() {
        //given
        BigInteger num1 = new BigInteger("20");
        BigInteger num2 = BigInteger.TEN;

        //when
        BigInteger actual = Calculator.subtract(num1, num2);

        //then
        assertThat(actual).isEqualTo(10);
    }

    @Test
    void 계산기_곱셈_기능을_테스트한다() {
        //given
        BigInteger num1 = BigInteger.TEN;
        BigInteger num2 = new BigInteger("20");

        //when
        BigInteger actual = Calculator.multiply(num1, num2);

        //then
        assertThat(actual).isEqualTo(200);
    }

    @Test
    void 계산기_나눗셈_기능을_테스트한다() {
        //given
        BigInteger num1 = new BigInteger("6");
        BigInteger num2 = new BigInteger("2");

        //when
        BigInteger actual = Calculator.divide(num1, num2);

        //then
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "5 * 4 + 3 / 2 - 5=6"}, delimiter = '=')
    void 사칙연산_기능을_구현한다(String input, int expected) {
        //given
        InputValidator.isNullOrEmpty(input);
        String[] inputArray = input.split(" ");
        BigInteger result = new BigInteger(inputArray[0]);

        //when
        for (int i = 1; i < inputArray.length; i += 2) {
            result = calculate(result, inputArray[i], new BigInteger(inputArray[i + 1]));
        }

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void 입력값이_null이거나_공백이면_예외를_발생시킨다(String input) {
        //then
        assertThatThrownBy(() -> InputValidator.isNullOrEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 null이거나 빈 공백이 올 수 없습니다. input = " + input);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.isNullOrEmpty(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 3", "2 - 1 1", "3 * 6 18", "6 / 3 2"}, delimiter = ' ')
    void 사칙연산_기호_타입을_검증한다(String number1, String operator, String number2, String expected) {
        // then
        assertThat(calculate(new BigInteger(number1), operator, new BigInteger(number2)))
                .isEqualTo(new BigInteger(expected));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculate(BigInteger.ONE, ":", BigInteger.TWO));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 문자열을_BigInteger_타입으로_변환한다(String input) {
        // then
        BigInteger actual = new BigInteger(input);
        assertThat(actual).isEqualTo(new BigInteger(input));
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new BigInteger("*"));
    }

    private BigInteger calculate(BigInteger number1, String operator, BigInteger number2) {
        switch (operator) {
            case "+":
                return Calculator.add(number1, number2);
            case "-":
                return Calculator.subtract(number1, number2);
            case "*":
                return Calculator.multiply(number1, number2);
            case "/":
                return Calculator.divide(number1, number2);
            default:
                throw new IllegalArgumentException("해당 연산자는 존재하지 않습니다 operator = " + operator);
        }
    }
}
