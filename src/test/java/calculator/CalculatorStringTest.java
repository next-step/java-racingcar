package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorStringTest {

    private CalculatorString calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorString();
    }

    @DisplayName("정상 문자열에 대한 테스트")
    @ParameterizedTest
    @MethodSource
    void calculatorSuccess(String input, int expected) {
        int result = calculator.stringCalculator(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> calculatorSuccess() {
        return Stream.of(
                Arguments.of("3 + 2 * 4 / 5", 4),
                Arguments.of("4 + 6 * 2 / 10", 2)
        );
    }

    @DisplayName("이상 문자열에 대한 테스트")
    @Test
    void calculatorError() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "25 + 5 * ";
            calculator.stringCalculator(input);
        });
    }

    @DisplayName("null 또는 빈 문자열 입력시 에러 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyCalculatorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.stringParser(input);
        });

    }

    @DisplayName("정상적이지 않은 사칙연산 부호에 대한 테스트")
    @Test
    void calculatorSymbolTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "2 ) 3 * 4 / 2";
            calculator.stringCalculator(input);
        });

    }

    @DisplayName("분자를 0으로 나누려 할때")
    @Test
    void divisionWithZero() {

        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            String input = "2 + 3 * 4 / 0";
            calculator.stringCalculator(input);
        }).withMessage("분모가 0일수 없습니다.");
    }

    @DisplayName("숫자 입력이 아닐시 에러 발생")
    @Test
    void parserIntTest() {
        String[] strings = {"a"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.parserInt(strings, 0);
        });
    }
}