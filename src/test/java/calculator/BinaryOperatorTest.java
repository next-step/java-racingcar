package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;

public class BinaryOperatorTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @ParameterizedTest
    @CsvSource({
            "10, 120",
            "10, -123",
            "20, 492"
    })
    void 덧셈_테스트(int operand1, int operand2) {
        BinaryOperator addition = BinaryOperator.of("+");
        assertThat(addition.calculate(operand1, operand2)).isEqualTo(operand1 + operand2);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 120",
            "10, -123",
            "20, 492"
    })
    void 뺄셈_테스트(int operand1, int operand2) {
        BinaryOperator subtraction = BinaryOperator.of("-");
        assertThat(subtraction.calculate(operand1, operand2)).isEqualTo(operand1 - operand2);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 120",
            "10, -123",
            "20, 492"
    })
    void 곱셈_테스트(int operand1, int operand2) {
        BinaryOperator multiplication = BinaryOperator.of("*");
        assertThat(multiplication.calculate(operand1, operand2)).isEqualTo(operand1 * operand2);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 120",
            "10, -123",
            "20, 492"
    })
    void 나눗셈_테스트(int operand1, int operand2) {
        BinaryOperator division = BinaryOperator.of("/");
        assertThat(division.calculate(operand1, operand2)).isEqualTo(operand1 / operand2);
    }

    @Test
    void 나눗셈은_0으로_나누면_예외를_발생시킨다() {
        BinaryOperator division = BinaryOperator.of("/");

        assertThatThrownBy(() -> {
            division.calculate(Integer.MAX_VALUE, 0);
        }).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void overflow가_발생할때_별도의_예외는_없다() {
        BinaryOperator addition = BinaryOperator.of("+");
        assertThat(addition.calculate(Integer.MAX_VALUE, 1)).isEqualTo(Integer.MIN_VALUE);
    }
}