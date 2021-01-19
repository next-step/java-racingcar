package calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class CalculatorTest {
    static Calculator calc;

    @BeforeAll
    static void initAll() {
        calc = new Calculator();
        System.out.println("start Calculator test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end Calculator test");
    }

    // a static method that returns a Stream of Arguments
    private static Stream<Arguments> provideArrayDequeForExpression() { // argument source method
        String[] expression = {"2", "*", "3", "/", "7"};
        ArrayDeque<String> expressionDeque = new ArrayDeque<>(Arrays.asList(expression));

        String[] expression2 = {"13", "+", "20", "/", "17"};
        ArrayDeque<String> expressionDeque2 = new ArrayDeque<>(Arrays.asList(expression2));

        String[] expression3 = {"5", "*", "3.2"};
        ArrayDeque<String> expressionDeque3 = new ArrayDeque<>(Arrays.asList(expression3));

        String[] expression4 = {"5", "-", "7"};
        ArrayDeque<String> expressionDeque4 = new ArrayDeque<>(Arrays.asList(expression4));

        return Stream.of(
                Arguments.of(expressionDeque, 0.85714),
                Arguments.of(expressionDeque2, 1.94117),
                Arguments.of(expressionDeque3, 16.0),
                Arguments.of(expressionDeque4, -2.0)
        );
    }

    @DisplayName("calculate Test: 식 계산 결과 확인")
    @ParameterizedTest
    @MethodSource("provideArrayDequeForExpression")
    void calculateTest(ArrayDeque<String> expression, double result) {
        assertThat(calc.calculate(expression)).isCloseTo(new Double(result), within(0.01));
    }

    @DisplayName("add Test: 더하기 결과 확인")
    @Test
    void addTest() {
        assertThat(calc.add(1.1, 2.2)).isCloseTo(3.3, within(0.01));
        assertThat(calc.add(2.1, 432.8)).isCloseTo(434.9, within(0.01));
        assertThat(calc.add(1.131, 3.71)).isCloseTo(4.841, within(0.0001));
        assertThat(calc.add(0.1, 0.91)).isCloseTo(1.01, within(0.001));
    }

    @DisplayName("sub Test: 빼기 결과 확인")
    @Test
    void subTest() {
        assertThat(calc.sub(1.1, 2.2)).isCloseTo(-1.1, within(0.01));
        assertThat(calc.sub(432.8, 2.1)).isCloseTo(430.7, within(0.01));
        assertThat(calc.sub(1.131, 3.71)).isCloseTo(-2.579, within(0.0001));
        assertThat(calc.sub(0.1, 0.91)).isCloseTo(-0.81, within(0.001));
    }

    @DisplayName("mul Test: 곱하기 결과 확인")
    @Test
    void mulTest() {
        assertThat(calc.mul(1.1, 2.2)).isCloseTo(2.42, within(0.001));
        assertThat(calc.mul(2.1, 432.8)).isCloseTo(908.88, within(0.001));
        assertThat(calc.mul(1.131, 3.71)).isCloseTo(4.19601, within(0.000001));
        assertThat(calc.mul(0.1, 0.91)).isCloseTo(0.091, within(0.0001));
    }

    @DisplayName("div Test: 나누기 결과 확인")
    @Test
    void divTest() {
        assertThat(calc.div(1.1, 2.2)).isCloseTo(0.5, within(0.01));
        assertThat(calc.div(2.1, 432.8)).isCloseTo(0.0048, within(0.0001));
        assertThat(calc.div(1.131, 3.71)).isCloseTo(0.3048, within(0.0001));
        assertThat(calc.div(0.1, 0.91)).isCloseTo(0.1098, within(0.0001));

        assertThatThrownBy(() -> calc.div(321.2, 0.0)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> calc.div(42141.2, -0.0)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> calc.div(321.2, Double.valueOf("NaN"))).isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("selectOperator : 연산자 마다 알맞은 연산 되는지 확인")
    @Test
    void selectOperatorTest() {
        assertThat(calc.selectOperator("+", 1.1, 2.2)).isCloseTo(3.3, within(0.01));
        assertThat(calc.selectOperator("-", 432.8, 2.1)).isCloseTo(430.7, within(0.01));
        assertThat(calc.selectOperator("*", 2.1, 432.8)).isCloseTo(908.88, within(0.001));
        assertThat(calc.selectOperator("/", 0.1, 0.91)).isCloseTo(0.1098, within(0.0001));
    }
}
