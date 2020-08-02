package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class CalculatorTest {
    Calculator calculator;

    @ParameterizedTest
    @CsvSource(value = {"15:1 + 2 + 3 + 4 + 5", "300:100 + 50 - 30 / 2 * 5", "465:50 / 2 + 100 + 30 * 3",
                    "10:2 + 3 * 4 / 2"}, delimiter = ':')
    public void calculatorInstance(int result, String inputText) {
        calculator = new Calculator(inputText);
        Assertions.assertThat(calculator.getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","100 ] 100", "10 _ 2"})
    public void nulError(String args) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator = new Calculator(args);
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"true:5", "false:test", "true:6"}, delimiter = ':')
    public void isNumber(boolean result, String args) {
        calculator = new Calculator("1 + 1");
        Assertions.assertThat(calculator.isNumber(args)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:+", "true:-", "true:*", "true:/", "false:_", "false:="}, delimiter = ':')
    public void isOperationSymbol(boolean result, String args) {
        calculator = new Calculator("1 + 1");
        Assertions.assertThat(calculator.isOperationSymbol(args)).isEqualTo(result);
    }
}
