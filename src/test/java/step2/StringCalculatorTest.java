package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private static final String NUMBERS_REGEXP = "[0-9]";
    private static final String NOT_NUMBERS_REGEXP = "[+|-|*|/]";
    private static final String EMPTY_SPACE = "";
    private static final String WHITESPACE_DELIMITER = "\\s";

    private Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(null, true), Arguments.of("", true), Arguments.of(" ", true)
        );
    }

    private Stream<String> invalidSymbolStrings() {
        return Stream.of("2 ^ 1", "3 & 2", "4 % 2", "6 $ 1");
    }

    private Stream<Arguments> validSymbolStrings() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("2 * 3 / 4 - 2", -1),
                Arguments.of("2 + 3 / 5 * 8", 8),
                Arguments.of("2 - 3 + 4 * 9", 27)
        );
    }

    private Stream<Arguments> splitStrings() {
        return Stream.of(
                Arguments.of("2 + 3 / 5 * 6", NUMBERS_REGEXP, EMPTY_SPACE, WHITESPACE_DELIMITER, 6),
                Arguments.of("2 + 3 / 5 * 2", NOT_NUMBERS_REGEXP, EMPTY_SPACE, WHITESPACE_DELIMITER, 7)
        );
    }

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("주어진 문자열을 숫자와 연산자로 분리하는 테스트")
    @ParameterizedTest
    @MethodSource(value = "splitStrings")
    void splitTest(String given, String regExp, String replacement, String delimitExpression, int tokenSize) {
        String[] split = calculator.getSplit(given, regExp, replacement, delimitExpression);
        assertThat(split.length).isEqualTo(tokenSize);
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest(name = "{0} 와 {1}을 더하기 테스트")
    @CsvSource(value = {"3,1", "4,2"})
    void plusOperatorTest(Integer a, Integer b) {
        int sum = calculator.plus(a, b);
        assertThat(sum).isEqualTo(a + b);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest(name = "{0} 에서 {1}을 빼기 테스트")
    @CsvSource(value = {"3,1"})
    void subtractOperatorTest(Integer minuend, Integer subtrahend) {
        int result = calculator.subtract(minuend, subtrahend);
        assertThat(result).isEqualTo(minuend - subtrahend);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest(name = "{0} 와 {1}를 곱하는 테스트")
    @CsvSource(value = {"2,4"})
    void multiplyOperatorTest(Integer multiplicand, Integer multiplier) {
        int result = calculator.multiply(multiplicand, multiplier);
        assertThat(result).isEqualTo(multiplicand * multiplier);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest(name = "{0} 에서 {1}를 나누는 테스트")
    @CsvSource(value = {"6,3"})
    void divideOperatorTest(Integer dividend, Integer divisor) {
        int result = calculator.divide(dividend, divisor);
        assertThat(result).isEqualTo(dividend / divisor);
    }

    @DisplayName("입력 값이 `null`이거나 `빈 공백`에 대한 조건 메서드 검증 테스트")
    @ParameterizedTest(name = "입력 값이 `{0}` 인 경우 {1}")
    @MethodSource("blankStrings")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input, boolean expected) {
        assertThat(calculator.isBlank(input)).isEqualTo(expected);
    }

    @DisplayName("입력 값이 `null`이거나 `빈 공백` 문자인 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest(name = "입력 값이 `{0}` 인 경우 IllegalArgumentException 예외 발생")
    @MethodSource(value = "blankStrings")
    void isBlank_ThrowsIllegalArgumentException(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.apply(given));
    }

    @DisplayName("사칙연산 기호가 아닌 문자열이 입력된 경우의 예외처리 테스트")
    @ParameterizedTest(name = "입력된 문자열에 사칙연산 값이 아닌 `{0}` 경우 IllegalArgumentException 예외 테스트")
    @MethodSource(value = "invalidSymbolStrings")
    void invalidSymbol_FourRuleCalculationsExceptionTest(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    calculator.isContainsSymbol(given);
                });
    }

    @DisplayName("사칙 연산을 모두 포함 연산이 가능한 기능 구현 테스트")
    @ParameterizedTest(name = "`{0}`의 연산 결과 값은 : {1}")
    @MethodSource(value = "validSymbolStrings")
    void fourRuleCalculationSerialTest(String given, Integer expected) {
        assertThat(calculator.apply(given)).isEqualTo(expected);
    }
}
