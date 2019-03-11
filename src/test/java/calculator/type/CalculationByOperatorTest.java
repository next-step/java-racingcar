package calculator.type;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationByOperatorTest {

    @Test
    public void ADD_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String expression = "+";

        CalculationByOperator addType = CalculationByOperator.convertTypeByOperator(expression);
        int result = addType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void MULTI_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String expression = "*";

        CalculationByOperator addType = CalculationByOperator.convertTypeByOperator(expression);
        int result = addType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(200);
    }

    @Test
    public void DIV_type확인() {
        int leftNumber = 20;
        int rightNumber = 10;
        String expression = "/";

        CalculationByOperator addType = CalculationByOperator.convertTypeByOperator(expression);
        int result = addType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void SUB_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String expression = "-";

        CalculationByOperator addType = CalculationByOperator.convertTypeByOperator(expression);
        int result = addType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(-10);
    }
}