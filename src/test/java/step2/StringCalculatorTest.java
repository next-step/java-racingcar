package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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
                Arguments.of("+", Arrays.asList(10, 10), 20),
                Arguments.of("+", Arrays.asList(0, -5), -5),
                Arguments.of("+", Arrays.asList(0, 0), 0),
                Arguments.of("+", Arrays.asList(-10, -10), -20),
                Arguments.of("+", Arrays.asList(-10, 100), 90)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "addTestData")
    @DisplayName("덧셈 테스트")
    void add(String operation, List<Integer> list, int expected) {
        int result = Operator.getOperatorByCode(operation).calculate(list);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> subTestData() {
        return Stream.of(
                Arguments.of("-", Arrays.asList(10, 10), 0),
                Arguments.of("-", Arrays.asList(0, -5), 5),
                Arguments.of("-", Arrays.asList(0, 0), 0),
                Arguments.of("-", Arrays.asList(-10, -10), 0),
                Arguments.of("-", Arrays.asList(-10, 100), -110)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "subTestData")
    @DisplayName("뺄셈 테스트")
    void sub(String operation, List<Integer> list, int expected) {
        int result = Operator.getOperatorByCode(operation).calculate(list);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> mulTestData() {
        return Stream.of(
                Arguments.of("*", Arrays.asList(10, 10), 100),
                Arguments.of("*", Arrays.asList(0, -5), 0),
                Arguments.of("*", Arrays.asList(0, 0), 0),
                Arguments.of("*", Arrays.asList(-10, -10), 100),
                Arguments.of("*", Arrays.asList(-10, 100), -1000)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "mulTestData")
    @DisplayName("곱셈 테스트")
    void mul(String operation, List<Integer> list, int expected) {
        int result = Operator.getOperatorByCode(operation).calculate(list);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> divTestData() {
        return Stream.of(
                Arguments.of("/", Arrays.asList(10, 10), 1),
                Arguments.of("/", Arrays.asList(0, -5), 0),
                Arguments.of("/", Arrays.asList(-10, -10), 1),
                Arguments.of("/", Arrays.asList(-10, 5), -2),
                Arguments.of("/", Arrays.asList(10, -5), -2)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "divTestData")
    @DisplayName("나눗셈 테스트")
    void div(String operation, List<Integer> list, int expected) {
        int result = Operator.getOperatorByCode(operation).calculate(list);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IAE")
    void nullOrEmptyCheck() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(""));
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(" "));
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "^", "\\", "|"})
    @DisplayName("사칙연산 기호가 아닌 경우 IAE")
    void invalidOperationCheck(String operation) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperatorByCode(operation));
    }

}
