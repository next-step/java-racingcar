package stringCalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 문자열_계산(){
        Calculator calculator = new Calculator();
        Operator operator = new Operator();

        operator.add("+", (a, b) -> a + b);
        operator.add("-", (a, b) -> a - b);
        operator.add("*", (a, b) -> a * b);
        operator.add("/", (a, b) -> {
            if (b == 0) throw new DivideByZeroException();
            return a / b;
        });

        assertThat(calculator.executeResult("2 + 3 * 4 / 2 / 2"))
            .isEqualTo(5);


    }


}
