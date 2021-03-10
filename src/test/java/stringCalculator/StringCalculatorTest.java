package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void initStringCalculatorTest() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = "2000 + 21")
    @DisplayName("Adding Test")
    void adddingTest(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(2021);
    }

    @ParameterizedTest
    @ValueSource(strings = "2021 - 20")
    @DisplayName("Subtraction Test")
    void SubtractionTest(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(2001);
    }

    @ParameterizedTest
    @ValueSource(strings = "12 * 23")
    @DisplayName("Multiplication  Test")
    void multiplicationTest(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(276);
    }

    @ParameterizedTest
    @ValueSource(strings = "2020 / 10")
    @DisplayName("Division Test")
    void divisionTest(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(202);
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 /")
    @DisplayName("Invalid parameter Test - wrong param")
    void invalidParamTest1(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input))
                .withMessage("calculating param counts is not odd number");
    }

    @ParameterizedTest
    @ValueSource(strings = {"T E S + T", "2 + 3 % 4 / 2"})
    @DisplayName("Invalid parameter Test - not number")
    void invalidParamTest2(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input))
                .withMessage("calculating param is wrong : contained not number or wrong opterator");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 0", "20 / 0 * 4 / 5"})
    @DisplayName("Invalid parameter Test - divide by 0")
    void invalidParamTest3(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input))
                .withMessage("calculating param is wrong : can't divide by 0");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\t", "\n"})
    @DisplayName("Invalid parameter Test - null or blank")
    void invalidParamTest4(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input))
                .withMessage("input is null or empty");
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    @DisplayName("Valid parameter Test")
    void validParamTest(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 - 5 * 0 / 2 + 2")
    @DisplayName("Valid parameter Test")
    void validParamTest2(String input) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(2);
    }


}
