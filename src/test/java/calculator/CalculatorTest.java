package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력값 empty 일때 Exception 발생")
    void 입력값_null(String input) {
        assertThatThrownBy(() ->  calculator = new Calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validInteger 함수 Exception 발생")
    void 첫번째값_숫자인지_테스트() {
        calculator = new Calculator("+ 2 + 3");
        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    @DisplayName("사칙연산 성공")
    void 계산_테스트(String input, int expected) {
        Calculator cal = new Calculator(input);
        assertThat(cal.calculate()).isEqualTo(expected);
    }

    @Test
    @DisplayName("enum 값 가져오기")
    void enum_테스트() {
        assertThat(Operator.valueOf("PLUS").getOperator()).isEqualTo("+");
        assertThat(Arrays.stream(Operator.values())
                .filter( op -> op.getOperator().equals("+"))).contains(Operator.PLUS);

    }
}
