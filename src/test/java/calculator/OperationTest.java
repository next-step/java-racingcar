package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operation.*;
import static org.assertj.core.api.Assertions.*;

public class OperationTest {

    @ParameterizedTest
    @DisplayName("덧셈 테스트 코드")
    @CsvSource(value = {"2:3:5", "5:7:12", "-1:5:4", "-3:-4:-7"}, delimiter = ':')
    void plus(int firstValue, int secondValue, int result) {
        assertThat(PLUS.operation(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트 코드")
    @CsvSource(value = {"5:2:3", "2:5:-3", "10:10:0"}, delimiter = ':')
    void minus(int firstValue, int secondValue, int result) {
        assertThat(MINUS.operation(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 테스트 코드")
    @CsvSource(value = {"5:2:10", "2:6:12", "10:10:100"}, delimiter = ':')
    void multiply(int firstValue, int secondValue, int result) {
        assertThat(MULTIPLY.operation(firstValue,secondValue)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트 코드")
    @CsvSource(value = {"50:5:10", "6:2:3", "60:10:6"}, delimiter = ':')
    void division(int firstValue, int secondValue, int result) {
        assertThat(DIVISION.operation(firstValue,secondValue)).isEqualTo(result);
    }

    @Test
    @DisplayName("나눗셈 0으로 나눴을 시 예외처리 테스트 코드")
    void divisionValueZero() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    assertThat(DIVISION.operation(0,2)).isEqualTo(0);
                });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 예외 기호 테스트 코드")
    @CsvSource(value = {"@" ,"%" ,"$" , "&"})
    void arithmeticOperationCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operation.arithmeticOperationCheck(input);
        });
    }
}
