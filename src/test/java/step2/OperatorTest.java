package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1542,2929,4471", "99,1,100", "9992828,222222,10215050"})
    public void 덧셈_테스트(String input) {
        String number1String = input.split(",")[0];
        String number2String = input.split(",")[1];
        String answer = input.split(",")[2];

        BigDecimal number1 = new BigDecimal(number1String);
        BigDecimal number2 = new BigDecimal(number2String);
        BigDecimal result = Operator.PLUS.calculate(number1, number2);
        assertThat(result).isEqualTo(new BigDecimal(answer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-1", "123546,2929,120617", "999999,888888,111111", "9992828,222222,9770606"})
    public void 뺄셈_테스트(String input) {
        String number1String = input.split(",")[0];
        String number2String = input.split(",")[1];
        String answer = input.split(",")[2];

        BigDecimal number1 = new BigDecimal(number1String);
        BigDecimal number2 = new BigDecimal(number2String);
        BigDecimal result = Operator.MINUS.calculate(number1, number2);
        assertThat(result).isEqualTo(new BigDecimal(answer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,2", "100,200,20000", "123456,654,80740224", "9992828,222222,2220626223816"})
    public void 곱셈_테스트(String input) {
        String number1String = input.split(",")[0];
        String number2String = input.split(",")[1];
        String answer = input.split(",")[2];

        BigDecimal number1 = new BigDecimal(number1String);
        BigDecimal number2 = new BigDecimal(number2String);
        BigDecimal result = Operator.MULTIPLY.calculate(number1, number2);
        assertThat(result).isEqualTo(new BigDecimal(answer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,0", "2000,200,10", "123456,654,188"})
    public void 나눗셈_테스트(String input) {
        String number1String = input.split(",")[0];
        String number2String = input.split(",")[1];
        String answer = input.split(",")[2];

        BigDecimal number1 = new BigDecimal(number1String);
        BigDecimal number2 = new BigDecimal(number2String);
        BigDecimal result = Operator.DIVIDE.calculate(number1, number2);
        assertThat(result).isEqualTo(new BigDecimal(answer));
    }

}
