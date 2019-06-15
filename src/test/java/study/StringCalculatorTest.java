package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "2 + 3 * 4 / 2, 10",
            "1 + 3, 4",
            "1 - 3, -2",
            "2 + 4 / 2, 3",
            "1 - 1 - 2, -2",
            "4 * 2 / 1 + 3 + 2 - 1, 12"
    })
    void 계산_정상(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    void 입력값_공백_검증(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input));
    }

    @Test
    void 입력값_NULL_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(null));
    }

    @AfterEach
    void tearDown() {

    }
}
