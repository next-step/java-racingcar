package step2;


import Calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculateTest {
    //Calculator calculator;

    @Test
    @DisplayName("정상적인 덧셈 테스트")
    void AddTestFunction() {
        StringCalculator calculator = new StringCalculator();
        double result = calculator.calculate("1 + 2 + 3 + 4");
        assertThat(result).isEqualTo(10);
    }
    @Test
    @DisplayName("정상적인 뺄셈 테스트")
    void SubTestFunction() {
        StringCalculator calculator = new StringCalculator();
        double result = calculator.calculate("4 - 3 - 2 - 1");
        assertThat(result).isEqualTo(-2);
    }
    @Test
    @DisplayName("정상적인 곱셈 테스트")
    void MultipleTestFunction() {
        StringCalculator calculator = new StringCalculator();
        double result = calculator.calculate("4 * 3 * 2 * 1");
        assertThat(result).isEqualTo(24);
    }
    @Test
    @DisplayName("정상적인 나눗셈 테스트")
    void DivisionTestFunction() {
        StringCalculator calculator = new StringCalculator();
        double result = calculator.calculate("12 / 3 / 2 / 1");
        assertThat(result).isEqualTo(2);
    }
    @Test
    @DisplayName("비정상적인 공백 데이터 테스트")
    void WhiteSpaceInputDataTestFunction() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> {
            double result = calculator.calculate("         ");
        }).isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("비정상적인 널 데이터 테스트")
    void NullInputDataTestFunction() {
        StringCalculator calculator = new StringCalculator();
        String data = null;
        assertThatThrownBy(() -> {
            double result = calculator.calculate(data);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("비정상적인 데이터 테스트")
    void InvalidInputDataTestFunction() {
        StringCalculator calculator = new StringCalculator();
        String data = "1+ 2 + 4";
        assertThatThrownBy(() -> {
            double result = calculator.calculate(data);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 7:21", "5 - 4 * 10 / 5:2", "10 * 4 + 10 / 5 - 5:5"}, delimiter = ':')
    void MixArithmeticCsvSourceTestFunction(String input, double expected) {
        StringCalculator calculator = new StringCalculator();
        double result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }



    /*입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    사칙연산 기호가 아닌 경우 IllegalArgumentException throw*/


}
