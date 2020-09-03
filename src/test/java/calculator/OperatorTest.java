package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void of() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBSTRACT);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLE);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

}
