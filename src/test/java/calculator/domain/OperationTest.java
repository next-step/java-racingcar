package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @Test
    void operation_생성_테스트() {
        Operation operation = Operation.from("+");
        assertThat(operation.isEqual("+")).isTrue();
    }

    @Test
    void operation_예외_테스트() {
        assertThatThrownBy(() -> Operation.from(";"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void operate_연산_테스트() {
        Operation operation = Operation.from("+");
        assertThat(operation.operate(new Operand(1), new Operand(2))).isEqualTo(3);
    }
}