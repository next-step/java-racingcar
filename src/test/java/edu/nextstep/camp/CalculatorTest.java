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
}
