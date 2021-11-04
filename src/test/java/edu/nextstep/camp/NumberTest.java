package edu.nextstep.camp;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {
    final Random random = new Random();

    @Test
    @SuppressWarnings("all")
    public void create() {
        final Number n = Number.of(5);
        assertThat(n.equals(Number.of(5))).isTrue();
        assertThat(n.equals(Number.of("5"))).isTrue();
        assertThat(n.toInt()).isEqualTo(5);
        assertThat(n.equals(5)).isTrue();
        assertThat(n.equals("5")).isTrue();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "not-a-number"})
    public void createFailed(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(number));
    }

    @Test
    public void testAdd() {
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(Number.of(m).add(Number.of(n))).isEqualTo(Number.of(m + n));
    }

    @Test
    public void testSubtract() {
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(Number.of(m).subtract(Number.of(n))).isEqualTo(Number.of(m - n));
    }

    @Test
    public void testProduct() {
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(Number.of(m).product(Number.of(n))).isEqualTo(Number.of(m * n));
    }

    @Test
    public void testDivide() {
        int m = random.nextInt();
        int n = random.nextInt();
        assertThat(Number.of(m).divide(Number.of(n))).isEqualTo(Number.of(m / n));
    }


    @Test
    public void testDivideBy0() {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(5).divide(Number.of(0)));
    }
}
