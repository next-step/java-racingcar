package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @Test
    void get() {
        assertThat(Operator.get("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.get("-")).isEqualTo(Operator.SUBTRACT);
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

    @Test
    void add() {
        assertThat(Operator.ADD.operate(1D, 3D)).isEqualTo(4D);
    }

    @Test
    void subtract() {
        assertThat(Operator.SUBTRACT.operate(3D, 10D)).isEqualTo(-7D);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.operate(5D, 3D)).isEqualTo(15D);
    }

    @Test
    void divide() {
        assertThat(Operator.DIVIDE.operate(10D, 2D)).isEqualTo(5D);
    }

    @Test
    void divide_0으로_나눔() {

        // given
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(1D, 0D));
        Terms terms = new Terms();
        terms.addTermAll(values);

        List<Operator> ops = new ArrayList<>(Arrays.asList(Operator.DIVIDE));
        Operators operators = new Operators();
        operators.addOperatorAll(ops);

        assertThrows(ArithmeticException.class, () -> Calculator.evaluate(terms, operators));
    }
}
