package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void separatingValueFromTheOperatorTest(String input) {
        stringCalculator.separatingValueFromTheOperator(input);
        assertThat(stringCalculator.getIntValues()).contains(2, 3, 4, 2);
        assertThat(stringCalculator.getOperators()).contains("+", "*", "/");
    }

    @Test
    void computationLoof() {
        LinkedList<Integer> intValues = new LinkedList<>(Arrays.asList(2, 3, 4, 2));
        LinkedList<String> operators = new LinkedList<>(Arrays.asList("+", "*", "/"));

        int result = stringCalculator.computationLoof(intValues, operators);
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void execute(String input) {
        int result = stringCalculator.execute(input);
        assertThat(result).isEqualTo(10);
    }
}