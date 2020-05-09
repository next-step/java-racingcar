package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Calculator 사칙 연산")
class CalculatorTest {
    private int defaultNumber;

    @BeforeEach
    void setUp() {
        defaultNumber = 2;
    }

    @ParameterizedTest
    @CsvSource(value = {"1=3", "2=4", "-1=1", "-3=-1"}, delimiter = '=')
    void 덧셈(int startNumber, int result) {
        assertThat(Calculator.add(startNumber, defaultNumber)).isEqualTo(result);
    }
}