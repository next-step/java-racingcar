package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    final Calculator cal = new Calculator();

    @ParameterizedTest(name = "test invalid input: {arguments}")
    @NullSource
    @ValueSource(strings = {"", "+", "3", "1 $ 2", "6234 54", "3 + - 3", "4 - 1 /"})
    public void testInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(input));
    }

    @ParameterizedTest(name = "test invalid operator: {arguments}")
    @CsvSource(value = {"3 # 5", "8 6 3", "5 not-a-operator 3"})
    public void testInvalidOperator(String command) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(command));
    }

    @ParameterizedTest(name = "test simple calculate: {arguments}")
    @CsvSource(value = {"3 + 5,8", "8 - 3,5", "5 * 3,15", "5  * 3,15"})
    public void testSimpleCalculate(String command, int expected) {
        assertThat(cal.calculate(command)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "test complicate calculate: {arguments}")
    @CsvSource(value = {
            "2 + 3 * 4 / 2,10",
            "3 + 5 * 7 - 2,54",
            "8 - 3 / 2 * 4, 8",
            "5 * 3 + 4 / 2 + 14 - 3 * 2 + 5 / 2,22"
    })
    public void testComplicateCalculate(String command, int expected) {
        assertThat(cal.calculate(command)).isEqualTo(expected);
    }

    @Test
    public void testParseInvalidCommand() {
        final String invalid = "1 2";
        assertThatIllegalArgumentException().isThrownBy(() -> cal.parseCommand(invalid));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5,1;2;3;4;5", "1  2  3,1;2;3"})
    public void testParseCommand(String command, String expected) {
        assertThat(cal.parseCommand(command).collect(Collectors.joining(";"))).isEqualTo(expected);
    }

    @Test
    public void testCalculateRecursive() {
        final Number n = Number.of(2);
        final String[] input = {"+", "4", "+", "8", "/", "2"};
        final Iterator<String> iter = Arrays.stream(input).iterator();
        assertThat(cal.calculateRecursive(n, iter)).isEqualTo(Number.of(7));
    }
}
