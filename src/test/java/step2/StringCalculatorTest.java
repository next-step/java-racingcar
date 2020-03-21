package step2;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("파싱을 제대로 하는지 확인")
    void stringParseToDoubleTest() {
        double result = StringCalculator.stringParseToDouble("2.2");
        assertThat(result).isEqualTo(2.2);
    }

    @Test
    @DisplayName("파싱중 에러 발생")
    void errorStringParseToDoubleTest() {
        assertThatThrownBy(() -> {
            StringCalculator.stringParseToDouble("AB");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 / 5:1", "8 + 2 * 3 / 5:6"}, delimiter = ':')
    void calculateTest(final String inputStr, final double answer) {
        final double result = StringCalculator.calculator(inputStr);
        assertThat(result).isEqualTo(answer);
    }
}
