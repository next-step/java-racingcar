package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @Test
    void operation_생성_테스트() {
        Operation operation = new Operation("+");
        assertThat(operation.getOperation()).isEqualTo("+");
    }

    @Test
    void operation_예외_테스트() {
        assertThatThrownBy(() -> new Operation(";"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}