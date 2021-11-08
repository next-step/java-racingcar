package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void 사칙연산_확인() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADDITION);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBTRACTION);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVISION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "#", "&", "(", ")"})
    void 사칙연산이아닐경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.of(input).operate(new MyNumber(3), new MyNumber(2));
        }).withMessageMatching(Operator.VALID_REQUIRED_ARITHMETIC_MSG);

    }
}
