package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    @Test
    void add() {
        InputNumber result = Operator.getOperator(ADDITION).calculate(new InputNumber("3"), new InputNumber("5"));
        assertThat(result).isEqualTo(new InputNumber(8));
    }

    @Test
    void subtract() {
        InputNumber result = Operator.getOperator(SUBTRACTION).calculate(new InputNumber("5"), new InputNumber("3"));
        assertThat(result).isEqualTo(new InputNumber(2));
    }

    @Test
    void multiply() {
        InputNumber result = Operator.getOperator(MULTIPLICATION).calculate(new InputNumber("10"), new InputNumber("2"));
        assertThat(result).isEqualTo(new InputNumber(20));
    }

    @Test
    void divide() {
        InputNumber result = Operator.getOperator(DIVISION).calculate(new InputNumber("21"), new InputNumber("7"));
        assertThat(result).isEqualTo(new InputNumber(3));
    }

    @Test
    void invalidOperatorShouldReturnIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.getOperator("&").calculate(new InputNumber("1"), new InputNumber("7")))
                .withMessage("사칙 연산 기호가 아닙니다.");
    }
}
