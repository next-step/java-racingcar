package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.StringCalculator;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void plus() {
        assertThat(calculator.plus(5, 10)).isEqualTo(15);
        assertThat(calculator.plus(5, -5)).isEqualTo(0);
    }

    @Test
    public void minus() {
        assertThat(calculator.minus(5, -5)).isEqualTo(10);
        assertThat(calculator.minus(5, 5)).isEqualTo(0);
    }

    @Test
    public void divide() {
        assertThat(calculator.divide(15, 3)).isEqualTo(5);
        assertThat(calculator.divide(9, 9)).isEqualTo(1);
    }

    @Test
    public void divide_ShouldThrow_ArithmeticException() {
        assertThatThrownBy(() -> calculator.divide(10, 0)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void divide_ShouldReturn_FlooredResult() {
        assertThat(calculator.divide(19, 3)).isEqualTo(6);
        assertThat(calculator.divide(391, 100)).isEqualTo(3);
    }

    @Test
    public void multiply() {
        assertThat(calculator.multiply(5, 10)).isEqualTo(50);
        assertThat(calculator.multiply(8, -9)).isEqualTo(-72);
        assertThat(calculator.multiply(928363, 0)).isEqualTo(0);
    }

    // NOTE: KDY - NullAndEmptySource 는 현재 EXPERIMENTAL 상태이다.
    @ParameterizedTest
    @NullAndEmptySource
    public void checkEmpty_ShouldThrow_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.checkEmpty(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "2", "2+3", "2.3", "3 :3", "3 / 3" })
    public void checkEmpty_ShouldReturn_True(String input) {
        assertThat(calculator.checkEmpty(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = { ".", "4", "$", "{", "@" })
    public void checkValidOperator_ShouldThrow_IllegalArgumentException(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.checkValidOperator(operator));
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    public void checkValidOperator_ShouldReturn_True(String operator) {
        assertThat(calculator.checkValidOperator(operator)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = { "-5", "-3", "0", "2" ,"4", "19", "65534" })
    public void convertToInt_shouldReturn_Integer(String numberString) {
        assertThat(calculator.converToInt(numberString)).isEqualTo(Integer.parseInt(numberString));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-", "+-552", "5,553", "english" })
    public void convertToInt_shouldThrow_IllegalArgumentException(String wrongInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.convertToInt(wrongInput));
    }

    @ParameterizedTest
    @CsvSource(value = { "3 + 5:8", "3 - 5:-3", "3 * 5:15", "3 / 5:0", "3 + 5 - 90 / 4 * 7:-149"}, delimiter = ':')
    public void calculate(String expression, int exceptedResult) {
        assertThat(calculator.calculate(expression)).isEqualTo(exceptedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = { "4.2", "5 1 2", ".", "5+5", "3 + 5 ; 4", "5 - 3 * 20 . 5" })
    public void calculate_ShouldThrow_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}