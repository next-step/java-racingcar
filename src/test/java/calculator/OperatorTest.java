package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2+5,7", "2+5*3,21"})
    @DisplayName("계산 테스트")
    void repeatCalculate(String value, String result) {
        String[] valueArr = value.split("");
        int sum = Integer.parseInt(valueArr[0]);

        for(int i=1; i<valueArr.length; i+=2) {
            sum = Operator.calculate(valueArr[i], sum, Integer.parseInt(valueArr[i+1]));
        }

        assertThat(sum).isEqualTo(Integer.parseInt(result));
    }

    @Test
    @DisplayName("나눗셈 제수 0 예외 처리")
    void byZero() {
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> {
                Operator.calculate("/", 2, 0);
        }).withMessage("/ by zero");
    }

    @ParameterizedTest
    @DisplayName("연산자 테스트")
    @ValueSource(strings = {"#", "A"})
    void operatorException(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Operator.getOperator(value);
        }).withMessage("올바른 연산자가 아닙니다.");
    }
}
