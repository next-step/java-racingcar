package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @ParameterizedTest
    @CsvSource(value = {"2,1"})
    void calc(int a, int b) {
        assertThat(Calculator.calculators.get("+").calculate(a, b)).isEqualTo(3);
        assertThat(Calculator.calculators.get("-").calculate(a, b)).isEqualTo(1);
        assertThat(Calculator.calculators.get("*").calculate(a, b)).isEqualTo(2);
        assertThat(Calculator.calculators.get("/").calculate(a, b)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 + 2 * 3 / 2:9"}, delimiter = ':')
    void stringCalculatorTest(String inputStr, int result) {
        StringCalculator stringCalculator = new StringCalculator(inputStr);
        assertThat(stringCalculator.calculate()).isEqualTo(result);
    }


}
