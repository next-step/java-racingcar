package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 + 1 - 10 * 5 / 2:-10"}, delimiter = ':')
    @DisplayName("문자열 계산기 통합테스트")
    void stringCalculatorTest(String data, int expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(data);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> addTestData() {
        return Stream.of(
                Arguments.of("+", 10, 10, 20),
                Arguments.of("+", 0, -5, -5),
                Arguments.of("+", 0, 0, 0),
                Arguments.of("+", -10, -10, -20),
                Arguments.of("+", -10, 100, 90)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "addTestData")
    @DisplayName("덧셈 테스트")
    void add(String operation, int result, int value, int expected) {
        int calculateResult = Operator.getOperatorByCode(operation).calculate(result, value);
        assertThat(calculateResult).isEqualTo(expected);
    }

    static Stream<Arguments> subTestData() {
        return Stream.of(
                Arguments.of("-", 10, 10, 0),
                Arguments.of("-", 0, -5, 5),
                Arguments.of("-", 0, 0, 0),
                Arguments.of("-", -10, -10, 0),
                Arguments.of("-", -10, 100, -110)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "subTestData")
    @DisplayName("뺄셈 테스트")
    void sub(String operation, int result, int value, int expected) {
        int calculateResult = Operator.getOperatorByCode(operation).calculate(result, value);
        assertThat(calculateResult).isEqualTo(expected);
    }

    static Stream<Arguments> mulTestData() {
        return Stream.of(
                Arguments.of("*", 10, 10, 100),
                Arguments.of("*", 0, -5, 0),
                Arguments.of("*", 0, 0, 0),
                Arguments.of("*", -10, -10, 100),
                Arguments.of("*", -10, 100, -1000)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "mulTestData")
    @DisplayName("곱셈 테스트")
    void mul(String operation, int result, int value, int expected) {
        int calculateResult = Operator.getOperatorByCode(operation).calculate(result, value);
        assertThat(calculateResult).isEqualTo(expected);
    }

    static Stream<Arguments> divTestData() {
        return Stream.of(
                Arguments.of("/", 10, 10, 1),
                Arguments.of("/", 0, -5, 0),
                Arguments.of("/", -10, -10, 1),
                Arguments.of("/", -10, 5, -2),
                Arguments.of("/", 10, -5, -2)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "divTestData")
    @DisplayName("나눗셈 테스트")
    void div(String operation, int result, int value, int expected) {
        int calculateResult = Operator.getOperatorByCode(operation).calculate(result, value);
        assertThat(calculateResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IAE")
    void nullOrEmptyCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "^", "\\", "|"})
    @DisplayName("사칙연산 기호가 아닌 경우 IAE")
    void invalidOperationCheck(String operation) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(operation));
    }

}
