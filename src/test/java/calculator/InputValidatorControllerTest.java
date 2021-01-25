package calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorControllerTest {
    @BeforeAll
    static void initAll() {
        System.out.println("start validator test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end validator test");
    }

    @DisplayName("checkEmptyInputTest: 인풋 빈 값인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "    "})
    void checkEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.checkEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // a static method that returns a Stream of Arguments
    private static Stream<Arguments> provideArrayDequeForWrongExpression() { // argument source method
        String[] expression = {"2", "+"};
        ArrayDeque<String> expressionDeque = new ArrayDeque<>(Arrays.asList(expression));

        String[] expression2 = {"3", "3", "/"};
        ArrayDeque<String> expressionDeque2 = new ArrayDeque<>(Arrays.asList(expression2));

        String[] expression3 = {"5", "*", "-"};
        ArrayDeque<String> expressionDeque3 = new ArrayDeque<>(Arrays.asList(expression3));

        String[] expression4 = {"5", ".", "7"};
        ArrayDeque<String> expressionDeque4 = new ArrayDeque<>(Arrays.asList(expression4));

        return Stream.of(
                Arguments.of(expressionDeque),
                Arguments.of(expressionDeque2),
                Arguments.of(expressionDeque3),
                Arguments.of(expressionDeque4)
        );
    }

    @DisplayName("checkExpressionTest: 식 확인")
    @ParameterizedTest
    @MethodSource("provideArrayDequeForWrongExpression")
    void checkExpressionTest(ArrayDeque<String> expression) {
        assertThatThrownBy(() -> Validator.checkExpression(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}