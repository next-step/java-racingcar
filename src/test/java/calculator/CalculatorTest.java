package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 나눗셈_0으로_나눌_때() {
        String[] data = {"5", "/", "0"};
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute(data));
    }

    @Test
    void 덧셈() {
        String[] data = {"5", "+", "9"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(14);
    }

    @Test
    void 뺼셈_결과_음수() {
        String[] data = {"1", "-", "3"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(-2);
    }

    @Test
    void 곱셈() {
        String[] data = {"5", "*", "3"};
        Assertions.assertThat(calculator.execute(data)).isEqualTo(15);
    }

    @Test
    void 나눗셈_결과_2자리_이상() {
        String[] data = {"1", "/", "3"};
        double result = calculator.execute(data);
        Assertions.assertThat(result).isEqualTo(0.33);
    }
}