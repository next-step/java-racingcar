package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("Calculator 사칙 연산")
class CalculatorTest {
    private int defaultNumber;

    @BeforeEach
    void setUp() {
        defaultNumber = 2;
    }

    @ParameterizedTest
    @CsvSource(value = {"1=3", "2=4", "-1=1", "-3=-1"}, delimiter = '=')
    void 덧셈(int endNumber, int result) {
        assertThat(Calculator.add(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=0", "-1=3", "-3=5"}, delimiter = '=')
    void 뺄셈(int endNumber, int result) {
        assertThat(Calculator.subtract(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=1"}, delimiter = '=')
    void 나눗셈(int endNumber, int result) {
        assertThat(Calculator.divide(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=4", "3=6"}, delimiter = '=')
    void 곱셈(int endNumber, int result) {
        assertThat(Calculator.multiple(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 연산자일경우(String operation) {
        assertThat(Calculator.isOperator(operation)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "#"})
    void 연산자연산기호가아닌경우_IllegalArgumentException(String operation) {
        assertThatThrownBy(() -> {
            Calculator.checkOperationSign(operation);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
    }
}