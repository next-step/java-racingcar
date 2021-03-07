package StringCalculatorTest;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator(" ");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "2 + 3:5"}, delimiter = ':')
    void Given_TwoOperand_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1 + -2:-3", "-10 + -12:-22"}, delimiter = ':')
    void Given_TwoNegativeOperand_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0", "-1 - 3:-4", "3 - -2:5"}, delimiter = ':')
    void Given_MinusOperation_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 1:1", "-1 * 3:-3", "3 * -2:-6", "1 * 0:0"}, delimiter = ':')
    void Given_MultipleOperation_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 1:1", "-6 / 2:-3", "10 / -2:-5"}, delimiter = ':')
    void Given_DivideOperation_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 + 1:3", "1 - 1 + 2:2"}, delimiter = ':')
    void Given_ThreeOperand_When_Calc_Then_Success(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 10 * 3:33", "1 * 10 + 2 / 2:6"}, delimiter = ':')
    void When_Calc_Then_FirstOperationDo(String input, int expected) {
        int actual = stringCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Given_NullInput_When_Calc_Then_IllegalArgumentException() {
        String input = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        }).withMessageMatching("input is null");
    }

    @Test
    void Given_EmptyInput_When_Calc_Then_IllegalArgumentException() {
        String input = "";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        }).withMessageMatching("input is blank");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "     ", "\t"})
    void Given_BlankInput_When_Calc_Then_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        }).withMessageMatching("input is blank");
    }
}
