package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 + 5 + 10 : 20", "1 + 2 + 3 + 4 : 10", "5 + 2 + 4 : 11"}, delimiter = ':')
    @DisplayName("덧셈")
    public void add(String expression, int expected) throws Exception {
        //given

        //when
        Expression splitExpression = new Expression(expression);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(expected);
    }
    
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 - 5 - 10 : -10", "1 - 2 - 3 - 4 : -8", "5 - 2 - 4 : -1"}, delimiter = ':')
    @DisplayName("뺄셈")
    public void subtract(String expression, int expected) throws Exception {
        //given

        //when
        Expression splitExpression = new Expression(expression);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 * 5 * 10 : 250", "3 * 3 * 3 : 27", "5 * -2 * 10 : -100"}, delimiter = ':')
    @DisplayName("곱셈")
    public void multiply(String expression, int expected) throws Exception {
        //given

        //when
        Expression splitExpression = new Expression(expression);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 / 5 : 1", "27 / 3 / 2 : 4", "5 / -2 :-2"}, delimiter = ':')
    @DisplayName("나눗셈")
    public void divide(String expression, int expected) throws Exception {
        //given

        //when
        Expression splitExpression = new Expression(expression);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}에 올바르지 않는 사칙 연산 포함")
    @ValueSource(strings = {"5 * 3 ! 1", "2 / 2 @ 1", "4 + 2 # 1", "4 - 1 $ 1"})
    @DisplayName("올바르지 않은 사칙 연산")
    public void validateSymbol(String expression) throws Exception {
        //given

        //when

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Expression(expression));
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 + 5 / 2 * 3 : 15", "27 / 3 + 2 * 2 : 22", "5 / -2 + 2 * 100 :0"}, delimiter = ':')
    @DisplayName("모든 사칙 연산")
    public void validateAllSymbol(String expression, int expected) throws Exception {
        //given

        //when
        Expression splitExpression = new Expression(expression);
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(expected);
    }
}