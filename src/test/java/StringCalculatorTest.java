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
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {

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