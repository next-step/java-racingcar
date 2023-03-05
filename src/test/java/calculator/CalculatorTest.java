package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculatorTest {

    @Test
    void 계산기_덧셈_기능을_테스트한다() {
        //given
        int num1 = 10;
        int num2 = 20;

        //when
        int actual = Calculator.add(num1, num2);

        //then
        assertThat(actual).isEqualTo(30);
    }

    @Test
    void 계산기_뺄셈_기능을_테스트한다() {
        //given
        int num1 = 20;
        int num2 = 10;

        //when
        int actual = Calculator.subtract(num1, num2);

        //then
        assertThat(actual).isEqualTo(10);
    }

    @Test
    void 계산기_곱셈_기능을_테스트한다() {
        //given
        int num1 = 10;
        int num2 = 20;

        //when
        int actual = Calculator.multiply(num1, num2);

        //then
        assertThat(actual).isEqualTo(200);
    }

    @Test
    void 계산기_나눗셈_기능을_테스트한다() {
        //given
        int num1 = 6;
        int num2 = 2;

        //when
        int actual = Calculator.divide(num1, num2);

        //then
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "5 * 4 + 3 / 2 - 5"})
    void 사칙연산_기능을_구현한다(String input) {
        //given
        isNullOrEmpty(input);
        String[] inputArray = input.split(" ");
        int result = toInteger(inputArray[0]);

        //when
        for (int i = 1; i < inputArray.length; i += 2) {
            result = calculate(result, inputArray[i], toInteger(inputArray[i + 1]));
        }

        //then
        System.out.println("Result: " + result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void 입력값이_null이거나_공백이면_예외를_발생시킨다(String input) {
        //then
        assertThatThrownBy(() -> isNullOrEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 null이거나 빈 공백이 올 수 없습니다. input = " + input);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> isNullOrEmpty(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 3", "2 - 1 1", "3 * 6 18", "6 / 3 2"}, delimiter = ' ')
    void 사칙연산_기호_타입을_검증한다(String number1, String operator, String number2, String expected) {
        // then
        assertThat(calculate(toInteger(number1), operator, toInteger(number2)))
                .isEqualTo(toInteger(expected));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculate(1, ":", 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 문자열을_정수타입으로_변환한다(String input) {
        // then
        int actual = toInteger(input);
        assertThat(actual).isEqualTo(Integer.parseInt(input));
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> toInteger("*"));
    }

    private void isNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("해당 값은 null이거나 빈 공백이 올 수 없습니다. input = " + input);
        }
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private int calculate(int number1, String operator, int number2) {
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
