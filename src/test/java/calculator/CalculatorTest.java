package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 + 5:9"}, delimiter = ':')
    @DisplayName("+ 연산자가 있으면 덧셈 결과가 반환돠어야 한다.")
    void additionTest(String input, int expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "10 - 2:8", "2 - 8:-6"}, delimiter = ':')
    @DisplayName("- 연산자가 있으면 뺄셈 결과가 반환되어야 한다.")
    void subtractionTest(String input, int expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3:6", "10 * -2:-20"}, delimiter = ':')
    @DisplayName("* 연산자가 있으면 곱셈 결과가 반환되어야 한다.")
    void multiplyTest(String input, int expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 / 2:5", "-8 / -2:4", "5 / 2:2"}, delimiter = ':')
    @DisplayName("/ 연산자가 있으면 나눗셈 결과가 반환되어야 한다.")
    void divideTest(String input, int expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 Exception이 발생해야 한다.")
    void incorrectOperatorTest() {

        //given
        Calculator calculator = new Calculator();
        String input = "2 & 3";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessageMatching("Required correct operator!");
    }
}
