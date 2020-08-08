package study.calculator;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private static StringCalculator stringCalculator;

    @BeforeAll
    static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void empty(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("add test")
    void add() {
        // given
        String input = "7 + 8 + 2";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        assertEquals(17, actual);
    }
    @Test
    @DisplayName("subtract test")
    void subtract() {
        // given
        String input = "7 - 8";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        assertEquals(-1, actual);
    }
    @Test
    @DisplayName("multiply test")
    void multiply() {
        // given
        String input = "7 * 8";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        assertEquals(56, actual);
    }
    @Test
    @DisplayName("divide test")
    void divide() {
        // given
        String input = "8 / 4";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        assertEquals(2, actual);
    }
    @Test
    @DisplayName("divide by ZERO")
    void divideByZero() {
        assertThatThrownBy(() -> {
            String input = "8 / 0";
            int actual = stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("Input letters instead of int")
    void inputLetter() {
        assertThatThrownBy(() -> {
            String input = "a + 2";
            int actual = stringCalculator.calculate(input);
        }).isInstanceOf(NumberFormatException.class);
    }
    @Test
    @DisplayName("Input other words instead of operator")
    void inputOtherWords() {
        assertThatThrownBy(() -> {
            String input = "2 a 2";
            int actual = stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
