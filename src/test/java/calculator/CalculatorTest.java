package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @Test
    void 나눗셈_0으로_나눌_때() {
        String[] data = {"5", "/", "0"};
        calculator = new Calculator(data);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute());
    }

    @Test
    void 덧셈() {
        String[] data = {"5", "+", "9"};
        calculator = new Calculator(data);
        calculator.execute();
        Assertions.assertThat(calculator.getResult()).isEqualTo(14);
    }

    @Test
    void 뺼셈_결과_음수() {
        String[] data = {"1", "-", "3"};
        calculator = new Calculator(data);
        calculator.execute();
        Assertions.assertThat(calculator.getResult()).isEqualTo(-2);
    }

    @Test
    void 곱셈() {
        String[] data = {"5", "*", "3"};
        calculator = new Calculator(data);
        calculator.execute();
        Assertions.assertThat(calculator.getResult()).isEqualTo(15);
    }

    @Test
    void 나눗셈_결과_2자리_이상() {
        String[] data = {"1", "/", "3"};
        calculator = new Calculator(data);
        calculator.execute();
        Assertions.assertThat(calculator.getResult()).isEqualTo(0.33);
    }
}
