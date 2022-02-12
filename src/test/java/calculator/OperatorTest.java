package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void 연산자를_올바르게_매치하는지_확인() {
        Operator operator = Operator.matchOperator("+");
        assertThat(operator).isEqualTo(Operator.PLUS);
    }
}