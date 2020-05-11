import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    Calculator calculator = new Calculator();

    @DisplayName("조건에 맞는 문자열을 입력 받았을 때")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3 = 6.0", "4 + 2 / 3 = 2", "2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    void testCalc(String v, String expected) {
        assertEquals(calculator.calculate(v), Double.parseDouble(expected));
    }
}
