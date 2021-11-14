package level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    //덧셈
    @ParameterizedTest()
    @CsvSource({"1 + 2, 3", "1 + 2 + 3, 6"})
    void plus(String input, int expect) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor, 0);
        assertThat(result).isEqualTo(expect);
    }

    //뺄셈
    @ParameterizedTest()
    @CsvSource({"2 - 2, 0", "6 - 1 - 2, 3"})
    void minus(String input, int expect) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor, 0);
        assertThat(result).isEqualTo(expect);
    }

    //곱셈
    @ParameterizedTest()
    @CsvSource({"211 * 3, 633", " 2 * 3 * 4, 24"})
    void multiply(String input, int expect) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor, 0);
        assertThat(result).isEqualTo(expect);
    }

    //나눗셈
    @ParameterizedTest()
    @CsvSource({"1230 / 10, 123, 1000 /10 / 10 ,10"})
    void divide(String input, int expect) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor, 0);
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10", "10 / 2 * 5 + 7, 32"})
    void calculate(String input, int expect) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor, 0);
        assertThat(result).isEqualTo(expect);
    }
}