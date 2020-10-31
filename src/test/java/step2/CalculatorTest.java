package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {


    @DisplayName("문자열 계산기 통 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10","2 + 3 * 4 / 3:6"},delimiter = ':')
    public void test(String expression,Integer expect) {
        //when
        Calculator calculator = new Calculator(expression);
        int calc = calculator.calc();

        //Then
        assertThat(calc).isEqualTo(expect);
    }
}