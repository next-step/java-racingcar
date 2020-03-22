package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("곱셈 테스트")
    @CsvSource(value = {"1:2:2", "1:0:0", "-1:2:-2", "-2:-5:10"}, delimiter = ':')
    public void multiplyTest(int left, int right, int result) {
        assertThat(MULTIPLY.operate(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("덧셈 테스트")
    @CsvSource(value = {"1:2:3", "1:0:1", "-1:2:1", "-2:-5:-7"}, delimiter = ':')
    public void plusTest(int left, int right, int result) {
        assertThat(PLUS.operate(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트")
    @CsvSource(value = {"1:2:-1", "1:0:1", "-1:2:-3", "-2:-5:3"}, delimiter = ':')
    public void minusTest(int left, int right, int result) {
        assertThat(MINUS.operate(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트")
    @CsvSource(value = {"1:2:0", "1:1:1", "-1:2:0", "-2:-5:0"}, delimiter = ':')
    public void divideTest(int left, int right, int result) {
        assertThat(DIVIDE.operate(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("기호에 맞는 연산자가 잘 리턴되는지 테스트")
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    public void symbolTest(String symbol, Operator operator) {
        assertThat(Operator.of(symbol)).isEqualTo(operator);
    }
}