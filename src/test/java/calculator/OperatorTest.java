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
    void 메소드를_검증한다(String symbol, String expected) {
        assertThat(Operator.getOperator(symbol).name()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=3", "2=4", "-1=1", "-3=-1"}, delimiter = '=')
    void 덧셈(int endNumber, int result) {
        assertThat(Operator.PLUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=0", "-1=3", "-3=5"}, delimiter = '=')
    void 뺄셈(int endNumber, int result) {
        assertThat(Operator.MINUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=1"}, delimiter = '=')
    void 나눗셈(int endNumber, int result) {
        assertThat(Operator.DIVIDE.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=4", "3=6"}, delimiter = '=')
    void 곱셈(int endNumber, int result) {
        assertThat(Operator.MULTIPLY.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @Test
    void 연산시_Zero로_나누게되면_ArithmeticException() {
        int endNumber = 0;

        assertThatThrownBy(() -> {
            Operator.checkZeroDivide(endNumber);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("제로로 나누는건 허용되지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "#"})
    void 연산자연산기호가아닌경우_IllegalArgumentException(String operation) {
        assertThatThrownBy(() -> {
            Operator.getOperator(operation);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
    }
}