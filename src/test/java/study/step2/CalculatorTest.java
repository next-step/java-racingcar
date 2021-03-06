package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Plus 테스트")
    void plus(){
        int num1 = 3;
        int num2 = 5;
        assertThat(calculator.plus(num1, num2)).isEqualTo(8);
    }

    @Test
    @DisplayName("Minus 테스트")
    void minus(){
        int num1 = 3;
        int num2 = 5;
        assertThat(calculator.minus(num1, num2)).isEqualTo(-2);
    }

    @Test
    @DisplayName("Multiple 테스트")
    void multiple(){
        int num1 = 3;
        int num2 = 5;
        assertThat(calculator.multiple(num1, num2)).isEqualTo(15);
    }

    @Test
    @DisplayName("Divide 테스트")
    void divide(){
        int num1 = 5;
        int num2 = 3;
        assertThat(calculator.divide(num1, num2)).isEqualTo(1);
    }

    @Test
    @DisplayName("연산 테스트")
    void operate() {
        assertThat(calculator.operate("+", 3, 5)).isEqualTo(8);
    }
}

