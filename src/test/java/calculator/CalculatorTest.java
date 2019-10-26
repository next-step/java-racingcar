package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    void 덧셈() {

        //given
        String inputString = "2 + 3";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {

        //given
        String inputString = "5 - 2";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 곱셈() {

        //given
        String inputString = "3 * 4";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 나눗셈() {

        //given
        String inputString = "20 / 2";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 입력_값이_빈_공백일_경우_IllegalArgumentException_throw(String input) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @Test
    void 입력_값이_null일_경우_IllegalArgumentException_throw() {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1 b 2", "a b c"})
    void 사칙연산_기호가_아닌_경우_IllegalArgumentException(String input) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2", "3 * 5 + 2 -", "+ 1"})
    void 숫자_연산자가_올바르지_않을_경우_IllegalArgumentException(String input) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10",
            "5        + 3 * 2 - 6 / 2:5",
            "100 - 10    / 3 + 5 * 2:70",
            "10 - 1 - 1 -       1 - 1 - 1:5"
    }, delimiter = ':')
    void 사칙연산(String input, long result) {
        Calculator calculator = new Calculator();
        long number = calculator.calculate(input);
        assertThat(number).isEqualTo(result);
    }

}
