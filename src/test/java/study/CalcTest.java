package study;

import domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalcTest {

    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 3:6", "5 - 3:2", "4 * 3:12", "12 / 6:2", "2 + 3 * 4 / 2:10", "3 + 3 / 2 + 2:5"}, delimiter = ':')
    @DisplayName(value = "더하기, 빼기, 곱셈, 나누기 테스트")
    void 사칙연산_테스트(String input, Integer answer) {
        int result = calculator.calc(input);
        assertEquals(result, answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 + 4 ) 2", "  + 3 + 4 + 2"})
    @DisplayName(value = "사칙연산 부호에 불포함 및 공백 숫자 체크 예외처리 테스트")
    void 공백_사칙연산_예외처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calc(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 + 3 / 3 * 2", "3 + 3 / 0 + 2"})
    @DisplayName(value = "0으로 나눌 경우 또는 정수로 떨어지지 않을 경우 예외테스트")
    void ZERO_DIVISION(String input) {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            calculator.calc(input);
        }).isInstanceOf(ArithmeticException.class)
                .withStackTraceContaining("0으로 나눌수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @NullSource
    @DisplayName(value = "input값 공백 또는 NULL 체크 예외테스트")
    void 공백_NULL_예외처리(String input) {
        assertTrue(StringUtils.isBlank(input));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calc(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
