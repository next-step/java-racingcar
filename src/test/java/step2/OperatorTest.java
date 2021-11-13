package step2;

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

    @Test
    void 연산자_덧셈() {
        assertThat(Operator.plus(new MyNumber(7), new MyNumber(2))).isEqualTo(new MyNumber(9));
    }

    @Test
    void 연산자_뺼셈() {
        assertThat(Operator.minus(new MyNumber(7), new MyNumber(6))).isEqualTo(new MyNumber(1));
    }

    @Test
    void 연산자_곱셈() {
        assertThat(Operator.multiply(new MyNumber(2), new MyNumber(7))).isEqualTo(new MyNumber(14));
    }

    @Test
    void 연산자_나눗셈() {
        assertThat(Operator.divide(new MyNumber(20), new MyNumber(7))).isEqualTo(new MyNumber(2));
    }
}
