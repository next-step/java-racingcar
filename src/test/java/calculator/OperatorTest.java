package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    public void plus() {
        assertThat(Operator.PLUS.apply(1, 2)).isEqualTo(3);
    }
}
