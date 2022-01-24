package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void get() {
        assertThat(Operator.get("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.get("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.get("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.get("/")).isEqualTo(Operator.DIVIDE);
    }
}