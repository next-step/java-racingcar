package edu.nextstep.camp;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
    @ValueSource(strings = {""})
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
}
