
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "12, 12",
            "-12, -12"
    })
    void 숫자만있을시(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2, 3",
            "1 + 2 + 3, 6",
            "1 + 2 + 3 + 4, 10",
            "1 + -3, -2"
    })
    void 더하기테스트(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "3 - 2, 1",
            "1 - 2, -1",
            "3 - 2 - 5, -4",
            "-2 - -5 - -10, 13"

    })
    void 빼기테스트(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 / 2, 0",
            "-7 / -2, 3",
            "7 / -2, -3",
            "10 / 5 / 2, 1"

    })
    void 나누기테스트(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(output);
    }

    @Test
    void 나누기테스트_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("10 / 0"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @ParameterizedTest
    @CsvSource({
            "10 * 2, 20",
            "-1 * -2, 2",
            "-1 * 2, -2",
            "0 * 2, 0",
            "1 * 2 * 3 * 5, 30"
    })
    void 곱하기테스트(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "2 + 3 * 4 / 2, 10",
            "-1 * -2 + 8 * 30, 480"
    })
    void 계산테스트(String input, int answer) {
        int output = stringCalculator.calculate(input);
        assertThat(output).isEqualTo(answer);
    }



    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ","1 a 1", "1 1 1", "+"})
    public void 예외테스트(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }



}