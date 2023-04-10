package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("빈문자열이나 null이 입력된 경우 0을 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    public void test1(String expression){
        int result = stringCalculator.calculate(expression);
        int expected = 0;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 하나만 입력된 경우 그 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "12:12", "444:444"}, delimiter = ':')
    public void test2(String expression, int expected){
        int result = stringCalculator.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }


}