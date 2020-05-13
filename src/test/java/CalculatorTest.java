import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("기본 사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = { "+:6", "-:2", "*:8", "/:2" }, delimiter = ':')
    void calculate_basic(String symbol, String result) {
        assertThat(calculator.calculate("4 " + symbol + " 2"))
                .isEqualTo(result);
    }

    @DisplayName("고급 사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1 + 2 / 3:1", "2 * 3 - 5:1", "1 + 2 * 3 / 9:1" }, delimiter = ':')
    void calculate_advance(String input, String result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @DisplayName("예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "1 2", "1+2", "1 + 2 +" })
    void calculate_with_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
