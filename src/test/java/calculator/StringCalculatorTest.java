package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기")
class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열은 전달받아 수식을 계산한다.")
    void calculate(String expressionString, int expectedValue) {
        assertThat(StringCalculator.calculate(expressionString)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of("1 + 2 + 3 + 4 + 5", 15),
                Arguments.of("1 - 2 + 3 - 4 + 5", 3),
                Arguments.of("2 * 5 / 2", 5),
                Arguments.of("1 / 2", 0)
        );
    }

}