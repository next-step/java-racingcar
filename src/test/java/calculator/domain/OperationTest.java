package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperationTest {

    @DisplayName("더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:10:15", "100:300:400", "530:210:740"}, delimiter = ':')
    void addition(int prev, int next, int result) {
        assertThat(Operation.ADDITION.compute(prev, next))
                .isEqualTo(result);
    }

    @DisplayName("빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"50:10:40", "1020:300:720", "10:100:-90"}, delimiter = ':')
    void subtraction(int prev, int next, int result) {
        assertThat(Operation.SUBTRACTION.compute(prev, next))
                .isEqualTo(result);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"9:8:72", "20:40:800", "300:200:60000"}, delimiter = ':')
    void multiplication(int prev, int next, int result) {
        assertThat(Operation.MULTIPLICATION.compute(prev, next))
                .isEqualTo(result);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"30:6:5", "560:80:7", "990:10:99"}, delimiter = ':')
    void division(int prev, int next, int result) {
        assertThat(Operation.DIVISION.compute(prev, next))
                .isEqualTo(result);
    }

    @DisplayName("나누기 예외 처리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:0", "3:0"}, delimiter = ':')
    void divisionException(int prev, int next) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Operation.DIVISION.compute(prev, next));
    }
}
