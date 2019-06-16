package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringCalculator {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void addition(int number) {
        int num1 = number * 2;
        int num2 = number - 1;

        int result = calculator.Addition(num1, num2);
        assertThat(result).isEqualTo(num1 + num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void subtraction(int number) {
        int num1 = number * 2;
        int num2 = number - 1;

        int result = calculator.subtraction(num1, num2);
        assertThat(result).isEqualTo(num1 - num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void multiplication(int number) {
        int num1 = number * 2;
        int num2 = number - 1;

        int result = calculator.multiplication(num1, num2);
        assertThat(result).isEqualTo(num1 * num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
    void division(int number) {
        int num1 = number * 2;
        int num2 = number - 1;

        int result = calculator.division(num1, num2);
        assertThat(result).isEqualTo(num1 / num2);

    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyValue(String number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.nullAndEmptyValue(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!","@","#","4"})
    void checkPolicyOperator(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkPolicyOperator(operator));
    }
}
