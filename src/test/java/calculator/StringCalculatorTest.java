package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있다")
    @ParameterizedTest
    @MethodSource("source_calculate_validInput_shouldSucceed")
    public void calculate_validInput_shouldSucceed(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_calculate_validInput_shouldSucceed() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("2", 2),
                Arguments.of("2 + 1 + 5", 8),
                Arguments.of("2 - 1 - 5", -4),
                Arguments.of("2 * 1 * 5", 10),
                Arguments.of("2 / 1 / 2", 1),
                Arguments.of("12 + 100 - 51 * 21 / 3", 427)
        );
    }

    @DisplayName("입력 값이 null 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullSource
    public void calculate_nullInput_shouldFail(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @MethodSource("source_calculate_emptyInput_shouldFail")
    public void calculate_emptyInput_shouldFail(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_calculate_emptyInput_shouldFail() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("   ")
        );
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @MethodSource("source_calculate_invalidOperator_shouldFail")
    public void calculate_invalidOperator_shouldFail(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_calculate_invalidOperator_shouldFail() {
        return Stream.of(
                Arguments.of("2 + 1 ( 5"),
                Arguments.of("2 ! 1 - 5"),
                Arguments.of("2 * 1 , 5"),
                Arguments.of("2 / 1 / 2 & 5")
        );
    }

}
