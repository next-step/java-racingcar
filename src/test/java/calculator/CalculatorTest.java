package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        //calculator = new Calculator();
    }

    @Test
    void 입력값_null() {
        assertThatThrownBy(() ->  calculator = new Calculator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 첫번째값_숫자인지_테스트() {
        Calculator cal = new Calculator("+ 2 + 3");
        assertThatThrownBy(() -> cal.validInteger(cal.getExpression().split(" ")[0]))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    void 계산_테스트(String input, int expected) {
        Calculator cal = new Calculator(input);
        assertThat(cal.calculate()).isEqualTo(expected);
    }
}
