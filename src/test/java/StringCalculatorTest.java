import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    StringCalculator calculator;
    @Test
    @DisplayName("덧셈")
    void add() {
        assertThat(calculator.add(2,3)).isEqualTo(5);
        assertThat(calculator.add(0,9)).isEqualTo(9);
        assertThat(calculator.add(0,11)).isEqualTo(11);
        assertThat(calculator.add(13,1)).isEqualTo(14);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        assertThat(calculator.subtract(2,3)).isEqualTo(-1);
        assertThat(calculator.subtract(0,9)).isEqualTo(-9);
        assertThat(calculator.subtract(0,11)).isEqualTo(-11);
        assertThat(calculator.subtract(13,1)).isEqualTo(12);
        assertThat(calculator.subtract(3,1)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        assertThat(calculator.multiply(2,3)).isEqualTo(6);
        assertThat(calculator.multiply(0,9)).isEqualTo(0);
        assertThat(calculator.multiply(0,11)).isEqualTo(0);
        assertThat(calculator.multiply(13,1)).isEqualTo(13);
        assertThat(calculator.multiply(3,1)).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {

    }

    @BeforeEach
    void createInstance() {
        calculator = new StringCalculator();
    }
}