package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @Test
    void get() {
        assertThat(Operator.get("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.get("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.get("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.get("/")).isEqualTo(Operator.DIVIDE);
    }

    @ValueSource(strings = {"+", "-", "*", "/"})
    @ParameterizedTest
    void contains_true(String operator) {
        assertThat(Operator.contains(operator)).isTrue();
    }

    @ValueSource(strings = {"%", "1", "a", "#"})
    @ParameterizedTest
    void contains_false(String operator) {
        assertThat(Operator.contains(operator)).isFalse();
    }

}