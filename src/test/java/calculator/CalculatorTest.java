package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("int 배열 합 체크")
    void sum() {
        Calculator calculator = new Calculator(new int[]{1, 2, 3, 4});
        assertThat(calculator.sum()).isEqualTo(10);
    }
}
