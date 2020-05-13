package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void validateIsNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.validateIsNull(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 & 2"})
    @DisplayName("사칙연산 기호가 아닌 경우")
    void validateOperator(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.run(input));
    }

    @ParameterizedTest
    @MethodSource("provideFormula")
    void run(String input, double expected) {
        double result = StringCalculator.run(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionFormula")
    @DisplayName("식이 연산으로 끝날 경우")
    void runException(String input) {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(() -> {
            StringCalculator.run(input);
        }).withMessageMatching("계산을 할 수가 없습니다.");
    }

    private static Stream<Arguments> provideFormula() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("6 + 3 * 4 / 3", 12),
                Arguments.of("1 + 1 * 4 / 8", 1)
        );
    }

    private static Stream<Arguments> provideExceptionFormula() {
        return Stream.of(
                Arguments.of("2 + 3 * "),
                Arguments.of("7 /"),
                Arguments.of("3 * 2 -")
        );
    }
}
