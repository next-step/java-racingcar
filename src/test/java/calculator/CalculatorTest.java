package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 * 2 / 5 + 10=11", "-2 / 2 + 10 * 2 - 2=16"}, delimiter = '=')
    public void calculate(String inputData, int expected) {
        assertThat(calculator.calculate(inputData)).isEqualTo(expected);
    }

    @DisplayName("두번째 인자가 0으로 나누었을 때 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,0", "8,0"})
    public void divideSecondOperandZeroTest(int first, int second){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.MINUS.calculate(first, second);
                }).withMessageMatching("0으로 나눌 수 없습니다");
    }


    @DisplayName("두번째 인자가 0으로 나누었을 때 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10, 2", "5, 7", "-10, 2"}, delimiter = ',')
    public void eachOperatorTest(int first, int second) {

        assertThat(Operator.PLUS.calculate(first, second)).isEqualTo(first + second);

        assertThat(Operator.MINUS.calculate(first, second)).isEqualTo(first - second);

        assertThat(Operator.MULTIPLE.calculate(first, second)).isEqualTo(first * second);

        assertThat(Operator.DIVIDE.calculate(first, second)).isEqualTo(first / second);

    }






}
