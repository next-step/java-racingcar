package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("plus test")
    @CsvSource({"1 + 2, 3", "2 + 2, 4"})
    void plusTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("minus test")
    @CsvSource({"1 - 2, -1", "2 - 2, 0", "3 - 2, 1"})
    void minusTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }


}