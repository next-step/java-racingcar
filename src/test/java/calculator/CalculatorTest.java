package calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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
}
