package calculator;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    private Random random;
    private Operator operator;

    @BeforeEach
    void setUp() {
        random = new Random();
        operator = Operator.getInstance();
    }

    @Test
    @DisplayName("add 함수 테스트")
    void add() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(operator.add(operand1, operand2))
                .isEqualTo(operand1 + operand2);

    }

    @Test
    @DisplayName("subtract 함수 테스트")
    void subtract() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(operator.subtract(operand1, operand2))
                .isEqualTo(operand1 - operand2);

    }

    @Test
    @DisplayName("multiply 함수 테스트")
    void multiply() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(operator.multiply(operand1, operand2))
                .isEqualTo(operand1 * operand2);

    }

    @Test
    @DisplayName("divide 함수 테스트")
    void divide() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(operator.divide(operand1, operand2))
                .isEqualTo(operand1 / operand2);

    }

}
