package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 숫자이외의_값을_전달하면_RuntimeException_반환() {
        //given
        String notNumber = "문자";
        Calculator calculator = new Calculator();

        //then
        Assertions.assertThatThrownBy(() -> {
            calculator.calculate(notNumber);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수를_전달하면_RuntimeException_반환() {
        //given
        String negativeNumber = "-1";
        Calculator calculator = new Calculator();

        //then
        Assertions.assertThatThrownBy(() -> {
            calculator.calculate(negativeNumber);
        }).isInstanceOf(RuntimeException.class);
    }
}
