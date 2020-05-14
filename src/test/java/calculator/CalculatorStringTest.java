package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "25 + 5 * 4 / 2:60"}, delimiter = ':')
    void calculator(String input, int expected) {
        int result = calculator.stringCalculator(input);
        assertEquals(expected, result);
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
    @ParameterizedTest
    @CsvSource(value = {"2 ) 3 * 4 / 2:10"}, delimiter = ':')
    void calculatorSymbolTest(String input, int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.stringCalculator(input);
        });

    }

    @DisplayName("분자를 0으로 나누려 할때")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 0:10"}, delimiter = ':')
    void divisionWithZero(String input, int expected) {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            calculator.stringCalculator(input);
        });
    }

    @DisplayName("숫자 입력이 아닐시 에러 발생")
    @Test
    void parserIntTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.parserInt("a");
        });
    }
}