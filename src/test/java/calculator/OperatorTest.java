package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사칙 연산")
class OperatorTest {
    private int defaultNumber;

    @BeforeEach
    void setUp() {
        defaultNumber = 2;
    }

    @CsvSource(value = {"+:PLUS", "*:MULTIPLY", "-:MINUS", "/:DIVIDE"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("연산자 검증한다.")
    void getOperator(String symbol, String expected) {
        assertThat(Operator.getOperator(symbol).name()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=3", "2=4", "-1=1", "-3=-1"}, delimiter = '=')
    @DisplayName("뎃셈 연산 검증한다.")
    void PLUS_apply(int endNumber, int result) {
        assertThat(Operator.PLUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=0", "-1=3", "-3=5"}, delimiter = '=')
    @DisplayName("뺄셈 연산 검증한다.")
    void MINUS_apply(int endNumber, int result) {
        assertThat(Operator.MINUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=1"}, delimiter = '=')
    @DisplayName("나눗셈 연산 검증한다.")
    void DIVIDE_apply(int endNumber, int result) {
        assertThat(Operator.DIVIDE.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=4", "3=6"}, delimiter = '=')
    @DisplayName("곱셈 연산 검증한다.")
    void MULTIPLY_apply(int endNumber, int result) {
        assertThat(Operator.MULTIPLY.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    @DisplayName("연산시_Zero로_나누게되면_ArithmeticException")
    void checkZeroDivide(int startNumber) {
        assertThatThrownBy(() ->
                Operator.DIVIDE.apply(startNumber, 0)).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("제로로 나누는건 허용되지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "#"})
    @DisplayName("사칙연산자외에 형태가 들어왔을 때 예외처리를 확인한다.")
    void getOperator_IllegalArgumentException(String operation) {
        assertThatThrownBy(() ->
                Operator.getOperator(operation)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
    }
}