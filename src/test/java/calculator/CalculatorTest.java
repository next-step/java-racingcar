package calculator;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    @DisplayName("calculate 함수 정상적인 케이스")
    void calculateSuccess() {
        assertThat(calculator.calculate("2 + 3"))
                .isEqualTo(5);
        assertThat(calculator.calculate("2 + 3 * 4"))
                .isEqualTo(20);
        assertThat(calculator.calculate("2 + 3 * 4 / 2"))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("calculate 함수 실패하는 케이스")
    void calculateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                }).withMessageMatching("입력 값이 null");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                }).withMessageMatching("입력 값이 빈 공백 문자");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2");
                }).withMessageMatching("arr 의 길이는 3이상이어야 한다.");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2 + 3 *");
                }).withMessageMatching("arr 의 길이는 홀수여야 한다.");
    }
}