package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    void plus() {
        String input = "2 + 3";
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.add(input)).isEqualTo(5);
    }
}
