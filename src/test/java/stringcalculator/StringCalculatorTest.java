package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "1 - 1:0", "2 * 2:4", "4 / 2:2"}, delimiter = ':')
    void 이항연산(String input, int expected) {
        int result = StringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 + 1:3", "1 * 2 * 3 * 4:24", "8 / 2 / 2 / 2:1", "3 * 4 - 1 * 2:22"}, delimiter = ':')
    void 다항연산(String input, int expected) {
        int result = StringCalculator.calculate(input);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @NullSource
    void nullTest(String input){
        assertThatThrownBy(() -> StringCalculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyInputTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(""));
        assertThatThrownBy(() -> StringCalculator.calculate("")).isInstanceOf(IllegalArgumentException.class);
    }
}
