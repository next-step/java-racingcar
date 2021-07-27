package clac;

import calc.type.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    @Test
    @DisplayName("Operation type PLUS test")
    void operationAddTest() {
        assertThat(Operation.PLUS.calc(3, 5)).isEqualTo(8);
    }

    @Test
    @DisplayName("Operation type MINUS test")
    void operationSubTest() {
        assertThat(Operation.MINUS.calc(3, 5)).isEqualTo(-2);
    }

    @Test
    @DisplayName("Operation type MULTIPLY test")
    void operationMulTest() {
        assertThat(Operation.MULTIPLY.calc(2, 5)).isEqualTo(10);
    }

    @Test
    @DisplayName("Operation type DIVIDE test")
    void operationDivTest() {
        assertThat(Operation.DIVIDE.calc(10, 5)).isEqualTo(2);
    }

}

