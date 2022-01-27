package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.util.Parser;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 사칙연산_테스트() {
        String expression = "1 + 2 / 3 * 4 - 3";
        List<String> splitExpression = Parser.splitExpression(expression);
        Calculator calculator = new Calculator(splitExpression);
        int result = calculator.getResult();

        assertThat(result).isEqualTo(1);
    }
}