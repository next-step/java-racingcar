package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("더하기 연산 테스트")
    @CsvSource(value = {"-1:2:1", "1:0:1"}, delimiter = ':')
    void addTest(Double value, Double value2, Double expected) {
        assertThat(ADD.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("빼기 연산 테스트")
    @CsvSource(value = {"1:2:-1", "1:0:1"}, delimiter = ':')
    void subTractTest(Double value, Double value2, Double expected) {
        assertThat(SUBTRACT.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("곱하기 연산 테스트")
    @CsvSource(value = {"1:2:2", "1:0:0"}, delimiter = ':')
    void multiplyTest(Double value, Double value2, Double expected) {
        assertThat(MULTIPLY.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 연산 테스트")
    @CsvSource(value = {"4:2:2", "1:1:1", "2:4:0.5"}, delimiter = ':')
    void divideTest(Double value, Double value2, Double expected) {
        assertThat(DIVIDE.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 몫이 0인 경우 연산 테스트")
    @CsvSource(value = {"2:0"}, delimiter = ':')
    void divideZeroTest(Double value, Double value2) {
        assertThatThrownBy(() -> DIVIDE.operate(value, value2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");

    }

}
