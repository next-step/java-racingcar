package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("계산")
class CalculatorTest {
    private Calculator calculator;

    private static Stream<String> convertStringToDouble() {
        return Stream.of("t", "x", "~");
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 아닌 다른 문자가 들어왔을 때_NumberFormatException 예외처리 발생시킴")
    void convertStringToDouble(String input) {
        calculator = new Calculator(input);
        assertThatThrownBy(() ->
                calculator.runCalculator()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산하기위해 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 * 12=24", "1 + 2 - 4=-1", "8 / 2 + 3 * 6 - 1=41"}, delimiter = '=')
    @DisplayName("문자열 계산기가 정상 동작가능한지 확인 한다.")
    void runCalculator(String input, int result) {
        assertThat(new Calculator(input).runCalculator()).isEqualTo(result);
    }
}