package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private static StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add() {
        assertThat(Operator.ADD.getResult(4, 3)).isEqualTo(7);
    }

    @Test
    void subtract() {
        assertThat(Operator.SUBTRACT.getResult(7, 2)).isEqualTo(5);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.getResult(3, 7)).isEqualTo(21);
    }

    @Test
    void divide() {
        assertThat(Operator.DIVIDE.getResult(10, 2)).isEqualTo(5);
    }


    @Test
    void isEmpty() {
        assertThat(stringCalculator.isEmpty(null)).isTrue();
        assertThat(stringCalculator.isEmpty(" ")).isTrue();
    }

    @Test
    void calculate() {
        assertThat(stringCalculator.calculate("2 * 5 + 10 / 2")).isEqualTo(10);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.calculate("!"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.calculate("&"));
    }

    @Test
    void getOperator() {
        assertThat(Operator.getOperator("+")).isEqualByComparingTo(Operator.ADD);
        assertThat(Operator.getOperator("-")).isEqualByComparingTo(Operator.SUBTRACT);
        assertThat(Operator.getOperator("*")).isEqualByComparingTo(Operator.MULTIPLY);
        assertThat(Operator.getOperator("/")).isEqualByComparingTo(Operator.DIVIDE);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> Operator.getOperator("!"));
    }
}
