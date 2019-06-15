package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

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
    void 계산(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @AfterEach
    void tearDown() {

    }
}
