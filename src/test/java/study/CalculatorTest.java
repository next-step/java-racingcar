package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorTest {

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
        String operator = "+";

        int result = calculator.computation(num1, num2, operator);
        assertThat(result).isEqualTo(num1 + num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void subtraction(int number) {
        int num1 = number * 2;
        int num2 = number - 1;
        String operator = "-";
        int result = calculator.computation(num1, num2, operator);
        assertThat(result).isEqualTo(num1 - num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void multiplication(int number) {
        int num1 = number * 2;
        int num2 = number - 1;
        String operator = "*";
        int result = calculator.computation(num1, num2, operator);
        assertThat(result).isEqualTo(num1 * num2);

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
    void division(int number) {
        int num1 = number * 2;
        int num2 = number - 1;
        String operator = "/";
        int result = calculator.computation(num1, num2, operator);
        assertThat(result).isEqualTo(num1 / num2);

    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "4"})
    void checkPolicyOperatorException(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkPolicyOperator(operator));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void checkPolicyOperatorIsOk(String operator) {
        assertThat(calculator.checkPolicyOperator(operator)).isEqualTo(operator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "3 / 6 * 8 + 2"})
    void splitString(String formula) {
        String[] splitFormula = calculator.getSplitFormula(formula);
        assertThat(splitFormula).hasSize(7);
    }


}
