package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("splitAndSum 메서드에 null을 넣으면 0을 반환한다.")
    void splitAndSum_Null_Zero() {
        final int result = StringAddCalculator.splitAndSum(null);

        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    @DisplayName("splitAndSum 메서드에 빈 문자열, 공백, 개행을 넣으면 0을 반환한다.")
    void splitAndSum_Blank_Zero(final String blank) {
        final int result = StringAddCalculator.splitAndSum(blank);

        assertThat(result).isZero();
    }

    @Test
    @DisplayName("splitAndSum 메서드에 숫자 하나만 넣으면 그대로 해당 숫자를 반환한다.")
    void splitAndSum_SingleNumber() {
        final int result = StringAddCalculator.splitAndSum("10");

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2@3", "5:10@15", "1,2:3@6", "1:2,3@6", "1:2:3@6", "1,2,3@6"}, delimiter = '@')
    @DisplayName("splitAndSum 메서드에 지정된 구분자(쉼표, 콜론)를 포함한 수식을 넣으면 피연산자들의 합을 반환한다.")
    void splitAndSum_StandardDelimiter_SumOfOperands(final String expression, final int expectedResult) {
        final int actualResult = StringAddCalculator.splitAndSum(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("customDelimiterExpressionAndResult")
    @DisplayName("splitAndSum 메서드에 커스텀 구분자를 포함한 수식을 넣으면 피연산자들의 합을 반환한다.")
    void splitAndSum_CustomDelimiter_SumOfOperands(final String expression, final int expectedResult) {
        final int actualResult = StringAddCalculator.splitAndSum(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> customDelimiterExpressionAndResult() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//#\n3#10#5", 18),
                Arguments.of("//a\n11a0a3", 14)
        );
    }

    @ParameterizedTest
    @MethodSource("expressionWithNonNumericOperands")
    @DisplayName("splitAndSum 메서드에 숫자가 아닌 피연산자가 들어간 수식을 넣으면 RuntimeException을 던진다.")
    void splitAndSum_NonNumericOperands_RuntimeException(final String expression) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("수식을 이루는 피연산자는 반드시 숫자이어야 합니다.");
    }

    private static Stream<Arguments> expressionWithNonNumericOperands() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("1,a"),
                Arguments.of("a,1"),
                Arguments.of("a:b,c"),
                Arguments.of("//;\na"),
                Arguments.of("//;\n1;a"),
                Arguments.of("//;\na;1"),
                Arguments.of("//;\na;b;c")
        );
    }

    @ParameterizedTest
    @MethodSource("expressionWithNegativeOperands")
    @DisplayName("splitAndSum 메서드에 음수 피연산자가 들어간 수식을 넣으면 RuntimeException을 던진다.")
    void splitAndSum_NegativeOperands_RuntimeException(final String expression) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("피연산자는 반드시 0 이상이어야 합니다.");
    }

    private static Stream<Arguments> expressionWithNegativeOperands() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("-1,2"),
                Arguments.of("2,-1"),
                Arguments.of("1:-2,3"),
                Arguments.of("//;\n-1"),
                Arguments.of("//;\n-1;2"),
                Arguments.of("//;\n2;-1"),
                Arguments.of("//;\n1;-2;3")
        );
    }
}
