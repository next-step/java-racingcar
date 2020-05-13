package step2;


import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculateTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("정상적인 덧셈 테스트")
    void addTestFunction() {
        double result = calculator.calculate("1 + 2 + 3 + 4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("정상적인 뺄셈 테스트")
    void subTestFunction() {
        double result = calculator.calculate("4 - 3 - 2 - 1");
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("정상적인 곱셈 테스트")
    void multipleTestFunction() {
        double result = calculator.calculate("4 * 3 * 2 * 1");
        assertThat(result).isEqualTo(24);
    }

    @Test
    @DisplayName("정상적인 나눗셈 테스트")
    void divisionTestFunction() {
        double result = calculator.calculate("12 / 3 / 2 / 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("비정상적인 공백 데이터 테스트")
    void whiteSpaceInputDataTestFunction() {
        assertThatThrownBy(() -> {
            double result = calculator.calculate("         ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상적인 널 데이터 테스트")
    void nullInputDataTestFunction() {
        String data = null;
        assertThatThrownBy(() -> {
            double result = calculator.calculate(data);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상적인 데이터 테스트")
    void invalidInputDataTestFunction() {
        String data = "1+ 2 + 4";
        assertThatThrownBy(() -> {
            double result = calculator.calculate(data);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 7:21", "5 - 4 * 10 / 5:2", "10 * 4 + 10 / 5 - 5:5"}, delimiter = ':')
    void mixArithmeticCsvSourceTestFunction(String input, double expected) {
        double result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }
}
