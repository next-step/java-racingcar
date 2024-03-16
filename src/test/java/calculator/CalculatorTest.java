package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator sut = new Calculator();

    @ParameterizedTest
    @NullAndEmptySource
    void test_calculate_빈문자_또는_null_입력(String input) {
        String expected = "0";

        assertThat(sut.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123"})
    void test_calculate_숫자_하나_입력(String input) {
        String expected = input;

        String actual = sut.calculate(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2/3", "1,2,3/6", "11,2,3,4/20"}, delimiter = '/')
    void test_calculate_숫자_두개_컴마구분_입력(String input, String expected) {
        String actual = sut.calculate(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2/3", "1:2:3/6", "11:2:3:4/20"}, delimiter = '/')
    void test_calculate_숫자_두개_콜론_구분_입력(String input, String expected) {
        String actual = sut.calculate(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_calculate_커스텀_구분자_지정() {
        String input = "//;\n1;2;3";
        String expected = "6";
        String actual = sut.calculate(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_calculate_음수_입력_RuntimeException() {
        String input = "-1,2,3";

        assertThatThrownBy(() -> sut.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

}
