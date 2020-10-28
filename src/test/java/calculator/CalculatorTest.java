package calculator;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Random random;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        random = new Random();
        calculator = new Calculator();
    }

    @Test
    @DisplayName("add 함수 테스트")
    void add() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(calculator.add(operand1, operand2))
                .isEqualTo(operand1 + operand2);

    }

    @Test
    @DisplayName("subtract 함수 테스트")
    void subtract() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(calculator.subtract(operand1, operand2))
                .isEqualTo(operand1 - operand2);

    }

    @Test
    @DisplayName("multiply 함수 테스트")
    void multiply() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(calculator.multiply(operand1, operand2))
                .isEqualTo(operand1 * operand2);

    }

    @Test
    @DisplayName("divide 함수 테스트")
    void divide() {
        int operand1 = random.nextInt();
        int operand2 = random.nextInt();
        assertThat(calculator.divide(operand1, operand2))
                .isEqualTo(operand1 / operand2);

    }

}