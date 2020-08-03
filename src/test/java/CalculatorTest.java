import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringcalculator.ArithmeticArguments;
import stringcalculator.Calculator;
import stringcalculator.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;

class CalculatorTest {
    private ArithmeticArguments args;

    @BeforeEach
    void setUp() {
        Integer[] operands = new Integer[] {2, 3, 4, 2};
        Operator[] operators = new Operator[] {Operator.ADD, Operator.MULTIPLY, Operator.DIVIDE};

        args = new ArithmeticArguments(Arrays.asList(operands), Arrays.asList(operators));
    }

    @Test
    void calculateTest() {
        int result = Calculator.calculate(this.args);

        assertThat(result).isEqualTo(10);
    }
}