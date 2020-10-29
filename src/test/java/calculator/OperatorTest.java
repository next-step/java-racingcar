package calculator;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    private Random random;

    @BeforeEach
    void setUp() {
        random = new Random();
    }

    @Test
    @DisplayName("add 함수 테스트")
    void add() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(Operator.add(operand1, operand2))
                .isEqualTo(operand1 + operand2);

    }

    @Test
    @DisplayName("subtract 함수 테스트")
    void subtract() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(Operator.subtract(operand1, operand2))
                .isEqualTo(operand1 - operand2);

    }

    @Test
    @DisplayName("multiply 함수 테스트")
    void multiply() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(Operator.multiply(operand1, operand2))
                .isEqualTo(operand1 * operand2);

    }

    @Test
    @DisplayName("divide 함수 테스트")
    void divide() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(Operator.divide(operand1, operand2))
                .isEqualTo(operand1 / operand2);

    }

}