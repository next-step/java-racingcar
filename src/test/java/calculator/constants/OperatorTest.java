package calculator.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("isContains 메소드를 검증한다.")
    void isContainsOperatorTest(String symbol, boolean expected){
        assertThat(Operator.isContains(symbol)).isEqualTo(expected);
    }

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("getOperator 메소드를 통해 Operator가 null이 아닌지 검증한다.")
    void getOperatorTest(String symbol, boolean expected){
        assertThat(Objects.nonNull(Operator.getOperator(symbol))).isEqualTo(expected);
    }

    @CsvSource(value = {"3:4:7"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("더하기 테스트")
    void plusTest(double firstValue, double secondValue, double expected) {
        assertThat(Operator.PLUS.apply(firstValue, secondValue)).isEqualTo(expected);
    }
    @CsvSource(value = {"2:1:1"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("빼기 테스트")
    void minusTest(double firstValue, double secondValue, double expected) {
        assertThat(Operator.MINUS.apply(firstValue, secondValue)).isEqualTo(expected);
    }
    @CsvSource(value = {"2:3:6"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("곱하기 테스트")
    void multiplyTest(double firstValue, double secondValue, double expected) {
        assertThat(Operator.MULTIPLY.apply(firstValue, secondValue)).isEqualTo(expected);
    }

    @CsvSource(value = {"2:0"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("0으로 나누면 ArithmeticException 예외를 던진다.")
    void divisionWithZeroTest(double firstValue, double secondValue) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Operator.DIVIDE.apply(firstValue, secondValue));
    }
}
