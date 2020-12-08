package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private static final String VALUE_SEPARATOR = "::";

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 / 4" + VALUE_SEPARATOR + "1",
            "999 + 1 * 10 - 200" + VALUE_SEPARATOR + "9800",
            "999999 * 999999 + 293483 / 4" + VALUE_SEPARATOR + "249999573371",
            "1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 / 4" + VALUE_SEPARATOR + "5",
    })
    public void 계산_테스트_1(String input) {
        String expressionText = input.split(VALUE_SEPARATOR)[0];
        String answerText = input.split(VALUE_SEPARATOR)[1];

        MathematicalExpression expression = MathematicalExpression.of(expressionText);
        Calculator calculator = new Calculator(expression);
        BigDecimal result = calculator.calculate();
        assertThat(result).isEqualTo(new BigDecimal(answerText));
    }
}
