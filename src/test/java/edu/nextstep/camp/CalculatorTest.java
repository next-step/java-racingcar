package edu.nextstep.camp;

import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    final Calculator cal = new Calculator();
    final Random random = new Random();

    @Test
    public void testAdd() {
        assertThat(cal.add(3, 5)).isEqualTo(3 + 5);
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(cal.add(m, n)).isEqualTo(m + n);
    }

    @Test
    public void testSubtract() {
        assertThat(cal.subtract(8, 5)).isEqualTo(8 - 5);
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(cal.subtract(m, n)).isEqualTo(m - n);
    }

    @Test
    public void testProduct() {
        assertThat(cal.product(3, 5)).isEqualTo(3 * 5);
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(cal.product(m, n)).isEqualTo(m * n);
    }

    @Test
    public void testDivide() {
        assertThat(cal.divide(8, 5)).isEqualTo(8 / 5);
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(cal.divide(m, n)).isEqualTo(m / n);
    }

    @ParameterizedTest(name = "test invalid input: {arguments}")
    @ValueSource(strings = {"", "+", "3", "1 $ 2", "6234 54", "3 + - 3", "4 - 1 /"})
    public void testInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(input));
    }

    @Test
    public void testNullInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(null));
    }

    @ParameterizedTest(name = "test simple calculate: {arguments}")
    @CsvSource(value = {"3,+,5,8", "8,-,3,5", "5,*,3,15"})
    public void testCalculate(int first, String operand, int second, int expected) {
        assertThat(cal.calculate(first, operand, second)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "test invalid operand: {arguments}")
    @CsvSource(value = {"3,#,5", "8,6,3", "5,not-a-operand,3"})
    public void testInvalidOperand(int first, String operand, int second) {
        assertThatIllegalArgumentException().isThrownBy(() -> cal.calculate(first, operand, second));
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
}
