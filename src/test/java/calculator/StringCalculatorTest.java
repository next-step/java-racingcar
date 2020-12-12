package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("덧셈 테스트 코드")
    @CsvSource(value = {"2:3:5", "5:7:12", "-1:5:4", "-3:-4:-7"}, delimiter = ':')
    void plus(int firstValue, int secondValue, int result) {
        assertThat(PLUS.applyAsInt(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트 코드")
    @CsvSource(value = {"5:2:3", "2:5:-3", "10:10:0"}, delimiter = ':')
    void minus(int firstValue, int secondValue, int result) {
        assertThat(MINUS.applyAsInt(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 테스트 코드")
    @CsvSource(value = {"5:2:10", "2:6:12", "10:10:100"}, delimiter = ':')
    void multiply(int firstValue, int secondValue, int result) {
        assertThat(MULTIPLY.applyAsInt(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트 코드")
    @CsvSource(value = {"50:5:10", "6:2:3", "60:10:6"}, delimiter = ':')
    void division(int firstValue, int secondValue, int result) {
        assertThat(DIVISION.applyAsInt(firstValue,secondValue)).isEqualTo(result);
    }
}
