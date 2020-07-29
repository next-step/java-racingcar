import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 덧셈")
    void plusBiOperand() {
        String input = "1 + 2";
        int plus = calculator.plus(input);

        assertThat(plus).isEqualTo(3);
    }
}