package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "-1:1:0"}, delimiter = ':')
    @DisplayName("덧셈 연산 테스트")
    void addOperationTest(int num1, int num2, int expect) {
        int result = Operator.ADD.applyAsInt(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "-1:1:-2", "1:-1:2"}, delimiter = ':')
    @DisplayName("뺄셈 연산 테스트")
    void subtractOperationTest(int num1, int num2, int expect) {
        int result = Operator.SUBTRACT.applyAsInt(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:0:0", "1:-1:-1"}, delimiter = ':')
    @DisplayName("곱셈 연산 테스트")
    void multiplyOperationTest(int num1, int num2, int expect) {
        int result = Operator.MULTIPLY.applyAsInt(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "0:1:0", "1:-1:-1"}, delimiter = ':')
    @DisplayName("나눗셈 연산 테스트")
    void divideOperationTest(int num1, int num2, int expect) {
        int result = Operator.DIVIDE.applyAsInt(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    @DisplayName("문자열로 부터 상수값을 반환하는 테스트")
    void fromStringTest(String character, Operator operator) {
        assertThat(Operator.fromString(character)).isEqualTo(operator);
    }
}
