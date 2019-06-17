package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void separatingValueFromTheOperatorTest() {
        stringCalculator.separatingValueFromTheOperator("2 + 3 * 4 / 2");
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

    @Test
    void execute() {
        int result = stringCalculator.execute("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyValue(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringCalculator.nullAndEmptyValue(input));
    }
}