package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void of() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLE);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);

    }
}
