package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 덧셈을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"2 + 3,5", "2 + 3 + 5,10"})
    public void add(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 뺄셈을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"5 - 3,2", "5 - 3 - 5,-3"})
    public void subtraction(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 곱셈을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"2 * 3,6", "2 * 3 * 5,30"})
    public void multiplication(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 나눗셈을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"6 / 2,3", "12 / 3 / 2,2"})
    public void division(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 % 2", "a * 3", "123+10"})
    @DisplayName("요구사항에 위배되는 값을 입력하여 오류가 발생하는지 테스트")
    public void wrongDataOccurredException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            try {
                new StringCalculator(input).calculate();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                throw e;
            }
        });
    }

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 사칙연산을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "3 + 3 * 2,12"})
    public void calculate(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }
}
