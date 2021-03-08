package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.object.Calculator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculationTest {

    @ParameterizedTest
    @DisplayName("Step2 1.덧셈")
    @ValueSource(strings = {"10 + 20"})
    void plus(String data){
        Calculator cal = new Calculator();

        cal.validate(data);

        int result = cal.caculation(data);
        assertThat(result).isEqualTo(10 + 20);
        System.out.println(result);
    }

    @ParameterizedTest
    @DisplayName("Step2 2.뺄셈")
    @ValueSource(strings = {"10 - 20 - 1"})
    void minus(String data){
        Calculator cal = new Calculator();

        cal.validate(data);

        int result = cal.caculation(data);
        assertThat(result).isEqualTo(10 - 20 -1);
        System.out.println(result);
    }

    @ParameterizedTest
    @DisplayName("Step2 3.곱하기")
    @ValueSource(strings = { "3 * 6 * 6 * 8"})
    void multiply(String data){
        Calculator cal = new Calculator();

        cal.validate(data);

        int result = cal.caculation(data);
        assertThat(result).isEqualTo(3 * 6 * 6 * 8);
        System.out.println(result);
    }

    @ParameterizedTest
    @DisplayName("Step2 4.나누기")
    @ValueSource(strings = {"8 / 7"})
    void divide(String data){
        Calculator cal = new Calculator();

        cal.validate(data);

        int result = cal.caculation(data);
        assertThat(result).isEqualTo(8 / 7);
        System.out.println(result);
    }

    @ParameterizedTest
    @DisplayName("Step2 5.빈값 입력")
    @NullSource
    void inputEmptyData(String data){
        Calculator cal = new Calculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(()->{cal.validate(data);});
    }

    @ParameterizedTest
    @DisplayName("Step2 6.잘못된 연산자 입력")
    @ValueSource(strings = {"40 20 1 3 6", "5 3 4", "6 2 6", "8 6 7"})
    void inputWrongOperator(String data){
        Calculator cal = new Calculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{cal.validate(data);});
    }

    @ParameterizedTest
    @DisplayName("모든 사칙 연산")
    @ValueSource(strings = {"8 + 7 - 1 * 3 / 2 "})
    void  fourArithmeticOperations(String data){
        Calculator cal = new Calculator();

        cal.validate(data);

        int result = cal.caculation(data);
        assertThat(result).isEqualTo((8 + 7 - 1 )* 3 / 2);
        System.out.println(result);
    }
    
}
