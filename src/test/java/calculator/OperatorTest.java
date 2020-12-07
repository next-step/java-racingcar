package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("두 개 숫자 더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "3,4,7"})
    void addTest(int x, int y, int expected) {
        int result = Operator.ADDITION.operate(x, y);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 개 숫자 빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "4,4,0", "5,1,4"})
    void subtractTest(int x, int y, int expected) {
        int result = Operator.SUBTRACTION.operate(x, y);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 개 숫자 곱하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "4,4,16", "5,0,0"})
    void multipleTest(int x, int y, int expected) {
        int result = Operator.MULTIPLICATION.operate(x, y);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("두 개 숫자 나누기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "4,1,4"})
    void divideTest(int x, int y, int expected) {
        int result = Operator.DIVISION.operate(x, y);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 기호로 연산자 찾기")
    @ParameterizedTest
    @CsvSource(value = {"+,ADDITION", "-, SUBTRACTION", "*,MULTIPLICATION", "/,DIVISION"})
    void findOperatorTest(String symbol, String operatorName) {
        Operator operator = Operator.of(symbol);

        assertThat(operator).isNotNull();
        assertThat(operator).isEqualTo(Operator.valueOf(operatorName));
    }

    @DisplayName("잘못된 연산자 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"#", "_"})
    void throwIllegalArgumentTest(String symbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(symbol))
                .withMessageContaining("잘못된 연산자입니다.");
    }


}
