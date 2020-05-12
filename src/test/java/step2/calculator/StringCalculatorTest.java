package step2.calculator;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("사칙 연산을 모두 포함한 정상적인 계산 테스트")
    @ParameterizedTest
    @MethodSource("mockStringCalculator")
    public void checkWhetherOutputIsCorrect(String input, int output) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(input)).isEqualTo(output);
    }

    private static Stream<Arguments> mockStringCalculator() {
        return Stream.of(
                Arguments.of("1 * 2 * 3 + 4 / 5 - 6", "-4"),
                Arguments.of("1 * 3 * 10 / 5 - 1 + 10", "15"),
                Arguments.of("9 + 9 / 9 * 9 - 9", "9"),
                Arguments.of("3 * 2 * 2 / 2 - 1 + 3", "8")
        );
    }

    @DisplayName("비정상적인 input에 대한 calculate 메소드 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + + 2, 369, 1 * 30 -- 1, 8 * * 8"})
    public void throwExceptionWhenInputIsWrong(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator stringCalculator = new StringCalculator();
                    stringCalculator.calculate(input);
                });
    }
}
