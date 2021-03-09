package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.object.Calculator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTest {

    @ParameterizedTest
    @DisplayName("Step2 1.덧셈")
    @ValueSource(strings = {"10 + 20", "1 + 2 + 3 + 4 + 5", "50 + 20 + 30"})
    void plus(String data){
        Calculator calculator = new Calculator();

        calculator.validate(data);

        int result = calculator.caculation(data);

        assertTrue(result > 0);
    }

    @ParameterizedTest
    @DisplayName("Step2 2.뺄셈")
    @ValueSource(strings = {"10 - 20 - 1", "5 - 10 - 4", "12 - 33 - 55"})
    void minus(String data){
        Calculator calculator = new Calculator();

        calculator.validate(data);

        int result = calculator.caculation(data);

        assertTrue(result < 0);
    }

    @ParameterizedTest
    @DisplayName("Step2 3.곱하기")
    @ValueSource(strings = { "3 * 6 * 6 * 8"})
    void multiply(String data){
        Calculator calculator = new Calculator();

        calculator.validate(data);

        int result = calculator.caculation(data);
        assertThat(result).isEqualTo(3 * 6 * 6 * 8);
    }

    @ParameterizedTest
    @DisplayName("Step2 4.나누기")
    @ValueSource(strings = {"8 / 7"})
    void divide(String data){
        Calculator calculator = new Calculator();

        calculator.validate(data);

        int result = calculator.caculation(data);
        assertThat(result).isEqualTo(8 / 7);
    }

    @ParameterizedTest
    @DisplayName("Step2 5.빈값 입력")
    @NullSource
    void inputEmptyData(String data){
        Calculator calculator = new Calculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(()->{calculator.validate(data);});
    }

    @ParameterizedTest
    @DisplayName("Step2 6.잘못된 연산자 입력")
    @ValueSource(strings = {"40 20 1 3 6", "5 3 4", "6 2 6", "8 6 7"})
    void inputWrongOperator(String data){
        Calculator calculator = new Calculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{calculator.validate(data);});
    }

    @ParameterizedTest
    @DisplayName("모든 사칙 연산")
    @ValueSource(strings = {"8 + 7 - 1 * 3 / 2 "})
    void  fourArithmeticOperations(String data){
        Calculator calculator = new Calculator();

        calculator.validate(data);

        int result = calculator.caculation(data);
        assertThat(result).isEqualTo((8 + 7 - 1 )* 3 / 2);
    }

}
