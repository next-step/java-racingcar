package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 숫자이외의_값을_전달하면_RuntimeException_반환() {
        String notNumber = "문자";
        Calculator calculator = new Calculator();

        //then
        Assertions.assertThatThrownBy(() -> {
            calculator.calculate(notNumber);
        }).isInstanceOf(RuntimeException.class);
    }
}
