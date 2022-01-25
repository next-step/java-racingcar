package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class OperationTest {
    @Test
    void 더하기() {
        assertThat(Operation.addition(2, 3)).isEqualTo(5);
    }

    @Test
    void 빼기() {
        assertThat(Operation.subtraction(2, 3)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        assertThat(Operation.multiplication(2, 3)).isEqualTo(6);
    }

    @Test
    void 나누기() {
        assertThat(Operation.division(10, 2)).isEqualTo(5);
    }

}