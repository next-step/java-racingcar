package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import step2.calculator.Calculator;
import step2.calculator.exceptions.EmptyExpressionException;
import step2.calculator.exceptions.InvalidExpressionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void initCalculator() {
        calculator = new Calculator();
    }


    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvFileSource(resources = "/step2/expression_success_with_two_value.csv", numLinesToSkip = 1)
    public void 숫자_두개_계산_성공(String expression, int expected) {
        //given, when
        int result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvFileSource(resources = "/step2/expression_success_with_many_value.csv", numLinesToSkip = 1)
    public void 숫자_여러개_계산_성공(String expression, int expected) {
        //given, when
        int result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvFileSource(resources = "/step2/expression_fail_with_expression_value.csv", numLinesToSkip = 1)
    public void 잘못된_기호_계산_실패(String expression, int expected) {
        //given, when
        assertThatExceptionOfType(InvalidExpressionException.class).isThrownBy(() -> {
            calculator.calculate(expression);
        });
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvFileSource(resources = "/step2/expression_fail_with_number_value.csv", numLinesToSkip = 1)
    public void 잘못된_숫자_계산_실패(String expression, int expected) {
        //given, when
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            calculator.calculate(expression);
        });
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvFileSource(resources = "/step2/expression_fail_with_blank_and_null.csv", numLinesToSkip = 1)
    public void 비어있는_수식으로_계산_실패(String expression, int expected) {
        //given, when
        assertThatExceptionOfType(EmptyExpressionException.class).isThrownBy(() -> {
            calculator.calculate(expression);
        });
    }
}
