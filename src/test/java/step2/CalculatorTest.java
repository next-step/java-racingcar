package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 테스트")
class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    void setUp() { calculator = new Calculator(); }

    @DisplayName("간단한 사칙연산을 계산한다")
    @MethodSource("provideSimpleEquation")
    @ParameterizedTest(name = "{0} = {1}")
    void 간단한_사칙연산(String equation, Double result) {
        assertThat(calculator.calculate(equation)).isEqualTo(result);
    }

    @DisplayName("복잡한 사칙연산을 계산한다")
    @MethodSource("provideComplexEquation")
    @ParameterizedTest(name = "{0} = {1}")
    void 복잡한_사칙연산(String equation, Double result) {
        assertThat(calculator.calculate(equation)).isEqualTo(result);
    }

    @DisplayName("Null 혹은 Empty 값을 입력하면 IllegalArgumentException 을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest(name = "입력값 : {arguments}")
    void null_혹은_empty_입력(String nullOrEmpty) {
        assertThatThrownBy(() -> calculator.calculate(nullOrEmpty))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("불완전한 계산식을 입력할 경우 IllegalArgumentException 을 반환한다")
    @CsvSource({"1+ 0","1 * 1 ="})
    @ParameterizedTest(name = "입력값 : {arguments}")
    void 불완전한_계산식_입력(String invalidEquation) {
        assertThatThrownBy(() -> calculator.calculate(invalidEquation))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideSimpleEquation() {
        return Stream.of(
                Arguments.of("1 + 1", "2"),
                Arguments.of("2 - 4", "-2"),
                Arguments.of("2 * 2", "4"),
                Arguments.of("1 / 2", "0.5")
        );
    }

    private static Stream<Arguments> provideComplexEquation() {
        return Stream.of(
                Arguments.of("1 + 1 * 2 - 4", "0"),
                Arguments.of("2 - 4 / 2 * 2", "-2"),
                Arguments.of("2 * 2 + 1 / 2", "2.5"),
                Arguments.of("1 / 2 + 3 * 2", "7")
        );
    }
}