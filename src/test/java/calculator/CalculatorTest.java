package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Calculator.cal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6", "1,2:3=6", "1,2=3"}, delimiter = '=')
    void cal사용_통합테스트(String input, int expected) {
        assertThat(cal(input)).isEqualTo(expected);
    }

    @Test
    void minusException() {
        assertThatThrownBy(() -> cal("-1,2,3")).isInstanceOf(RuntimeException.class);
    }


    @Test
    void 숫자반환() {
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    void null_빈문자열_값() {
        assertThat(cal(null)).isEqualTo(0);
    }
}
