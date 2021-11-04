package edu.nextstep.camp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperationTest {
    @Test
    public void testAddition() {
        assertThat(Operation.ADDITION.operate(Number.of(5), Number.of(3))).isEqualTo(Number.of(8));
        assertThat(Operation.of("+").operate(Number.of(5), Number.of(3))).isEqualTo(Number.of(8));
    }

    @Test
    public void testSubtraction() {
        assertThat(Operation.SUBTRACTION.operate(Number.of(8), Number.of(3))).isEqualTo(Number.of(5));
        assertThat(Operation.of("-").operate(Number.of(8), Number.of(3))).isEqualTo(Number.of(5));
    }

    @Test
    public void testProduction() {
        assertThat(Operation.PRODUCTION.operate(Number.of(4), Number.of(2))).isEqualTo(Number.of(8));
        assertThat(Operation.of("*").operate(Number.of(4), Number.of(2))).isEqualTo(Number.of(8));
    }

    @Test
    public void testDivision() {
        assertThat(Operation.DIVISION.operate(Number.of(8), Number.of(4))).isEqualTo(Number.of(2));
        assertThat(Operation.of("/").operate(Number.of(8), Number.of(4))).isEqualTo(Number.of(2));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "#", "3", "anyString"})
    public void testInvalidOperator(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.of(operator));
    }
}
