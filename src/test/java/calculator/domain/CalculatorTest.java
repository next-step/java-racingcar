package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void evaluate() {

        // given
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 10D, 2D, 2D));
        Terms terms = new Terms();
        terms.addTermAll(values);

        List<Operator> ops = new ArrayList<>(
                Arrays.asList(Operator.ADD, Operator.ADD, Operator.MULTIPLY, Operator.SUBTRACT,
                        Operator.DIVIDE));
        Operators operators = new Operators();
        operators.addOperatorAll(ops);

        // when
        double result = Calculator.evaluate(terms, operators);

        // then
        assertThat(result).isEqualTo(29L);
    }
}
