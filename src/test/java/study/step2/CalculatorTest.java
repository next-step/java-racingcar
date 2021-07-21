package study.step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private final Interpreter interpreter = new SimpleInterpreter();
    private final Calculator calculator = new SimpleCalculator(interpreter);

    @ParameterizedTest(name = "덧셈 | {arguments}")
    @CsvSource(value = {"1 + 2:3", "4 + 0:4", "0 + 5:5"}, delimiter = ':')
    public void add(String input, int expected) {
        // given

        // when
        int result = calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "뺄셈 | {arguments}")
    @CsvSource(value = {"7 - 3:4", "1 - 2:-1", "4 - 0:4", "0 - 5:-5"}, delimiter = ':')
    public void subtract(String input, int expected) {
        // given

        // when
        int result = calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "곱셈 | {arguments}")
    @CsvSource(value = {"2 * 3:6", "1 * 2:2", "5 * 0:0", "0 * 3:0", "0 * 0:0"}, delimiter = ':')
    public void multiply(String input, int expected) {
        // given

        // when
        int result = calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "나눗셈 | {arguments}")
    @CsvSource(value = {"4 / 2:2", "0 / 5:0", "5 / 1:5"}, delimiter = ':')
    public void divide(String input, int expected) {
        // given

        // when
        int result = calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "복잡한 수식 | {arguments}")
    @CsvSource(value = {"4 / 2 + 5 * 3 - 2:19", "1 + 2 + 3 / 3 - 2 * 5:0", "-3 + 5 * 2 / 4 - 5:-4"}, delimiter = ':')
    public void complex(String input, int expected) {
        // given

        // when
        int result = calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

}
