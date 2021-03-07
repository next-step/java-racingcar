package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
    생각하면서 할 것!
    * 중복코드가 없도록 Test 어노테이션 종류를 잘 활용할 것
 */
public class CalculatorTest {

    private final StringCalculations calculations = new StringCalculations();

    @Test
    @DisplayName("덧셈에 대한 테스트")
    void sum() {
        // given
        int first = 1;
        int second = 2;
        int expected = 3;

        // when
        int result = calculations.calculate(first, "+", second);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("numTestValue")
    @DisplayName("뻴셈에 대한 테스트")
    void num(int first, int second, int expected) {
        assertThat(calculations.calculate(first, "-", second)).isEqualTo(expected);
    }

    private static Stream<Arguments> numTestValue() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(5, 1, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("multiTestValue")
    @DisplayName("곱셈에 대한 테스트")
    void multi(int first, int second, int expected) {
        assertThat(calculations.calculate(first, "*", second)).isEqualTo(expected);
    }

    private static Stream<Arguments> multiTestValue() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(0, 5, 0),
                Arguments.of(0, 3, 0),
                Arguments.of(-3, 6, -18)
        );
    }

    @ParameterizedTest
    @MethodSource("divTestValue")
    @DisplayName("나눗셈에 대한 테스트")
    void div(int first, int second, int expected) {
        assertThat(calculations.calculate(first, "/", second)).isEqualTo(expected);
    }

    private static Stream<Arguments> divTestValue() {
        return Stream.of(
                Arguments.of(1, 3, 0),
                Arguments.of(5, 3, 1),
                Arguments.of(0, 1, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,0"})
    @DisplayName("나눗셈 0으로 나누기 Exception 테스트")
    void divArithmeticException(int first, int second) {
        assertThatThrownBy(() -> {
            calculations.calculate(first, "/", second);
        }).isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 + 5,10", "4 - 2 * 5,10"})
    @DisplayName("여러 연산자가 들어왔을 경우 테스트")
    void calculateTest(String data, int expected) {
        assertThat(calculations.calculate(data)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "^"})
    @DisplayName("잘못된 연산자에 대한 테스트")
    void getOperator(String symbol) {
        assertThatThrownBy(() -> {
//            change to private
//            OperationManager.getOperator(symbol);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(String data) {
        assertThatThrownBy(() -> {
            calculations.calculate(data);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
