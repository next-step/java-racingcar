package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 문자열 사칙 연산 계산기 테스트
 */
class StringCalculatorTest {

    private StringCalculator calculator;

    private static Stream<Arguments> validSymbolStrings() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("2 * 3 / 4 - 2", -1),
                Arguments.of("2 + 3 / 5 * 8", 8),
                Arguments.of("2 - 3 + 4 * 9", 27)
        );
    }

    private static Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true)
        );
    }

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("입력 값이 `null`이거나 `빈 공백` 문자인 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest(name = "입력 값이 `{0}` 인 경우 IllegalArgumentException 예외 발생")
    @MethodSource(value = "blankStrings")
    void isBlank_ThrowsIllegalArgumentException(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(given));
    }

    @DisplayName("사칙 연산을 모두 포함 연산이 가능한 기능 구현 테스트")
    @ParameterizedTest(name = "`{0}`의 연산 결과 값은 : {1}")
    @MethodSource(value = "validSymbolStrings")
    void fourRuleCalculationSerialTest(String given, Integer expected) {
        assertThat(calculator.calculate(given)).isEqualTo(expected);
    }

    @DisplayName("사칙 연산이 아닌 연산이 포함되어 있는 경우 테스트")
    @ParameterizedTest(name = "{0} 연산 시 에외 발생")
    @CsvSource(value = {"2 & 1 + 1", "2 $ 1", "1 $ 1 % 1 ^ 1 ! 1"})
    void testCase1(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(given));
    }
}
