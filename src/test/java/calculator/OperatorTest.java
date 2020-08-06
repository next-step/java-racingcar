package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    @DisplayName("Operator 작동 테스트")
    void of() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLE);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }
}
