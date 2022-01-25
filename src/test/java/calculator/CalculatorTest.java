package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<String> data = Arrays.asList("5", "/", "0");
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute(data));
    }

    @Test
    void 덧셈() {
        List<String> data = Arrays.asList("5", "+", "9");
        Assertions.assertThat(calculator.execute(data)).isEqualTo(14);
    }

    @Test
    void 뺼셈_결과_음수() {
        List<String> data = Arrays.asList("1", "-", "3");
        Assertions.assertThat(calculator.execute(data)).isEqualTo(-2);
    }

    @Test
    void 곱셈() {
        List<String> data = Arrays.asList("5", "*", "3");
        Assertions.assertThat(calculator.execute(data)).isEqualTo(15);
    }

    @Test
    void 나눗셈_결과_2자리_이상() {
        List<String> data = Arrays.asList("1", "/", "3");
        double result = calculator.execute(data);
        Assertions.assertThat(result).isEqualTo(0.33);
    }
}