package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 / 4,1",
            "999 + 1 * 10 - 200,9800",
            "999999 * 999999 + 293483 / 4,249999573371",
            "1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 / 4,5",
    })
    public void 계산_테스트_1(String input){
        String expressionText = input.split(",")[0];
        String answerText = input.split(",")[1];

        MathematicalExpression expression = MathematicalExpression.of(expressionText);
        Calculator calculator = new Calculator(expression);
        BigDecimal result = calculator.calculate();
        assertThat(result).isEqualTo(new BigDecimal(answerText));
    }
}
