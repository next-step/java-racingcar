package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.model.Calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("Operator test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 - 5 + 10 / 7 * 100:100", "100 * 100:10000", " 100 / 100:1"}, delimiter = ':')
    public void calculator(String str, int expect) {
        assertEquals(Calculator.operator(str), expect);
    }

    @DisplayName("divide by zero exception test")
    @ParameterizedTest
    @CsvSource(value = {"100 / 0:1"}, delimiter = ':')
    public void divideByZeroException(String str, int expect) {
        assertThatThrownBy(() -> {
            Calculator.operator(str);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("나눗셈에서 분모는 0이 될 수 없습니다");
    }
}
