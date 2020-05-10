package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("표현식으로 '+, -, /, *' 을 입력하면 assertThatIllegalArgumentException 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"%", "&", "!", ""})
    void invalidExpressionTest(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.from(expression);
        }).withMessageMatching(String.format("'%s'사칙연산 기호가 올바르지 않습니다.", expression));
    }

    @DisplayName("표현식으로 '+, -, /, *' 만 사용할 수 있다")
    @ParameterizedTest
    @MethodSource("provideSourceForValidExpression")
    void validExpressionTest(String expression, Operator operator) {
        assertThat(Operator.from(expression)).isEqualTo(operator);
    }

    private static Stream<Arguments> provideSourceForValidExpression() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("/", Operator.DIVIDE),
                Arguments.of("*", Operator.MULTIPLY)
        );
    }

    @DisplayName("Operation.PLUS는 첫번쨰, 두번째 인자를 더한 값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2", "2,3,5", "3,4,7"})
    void plusTest(int a, int b, int result) {
        assertThat(Operator.PLUS.result(a, b)).isEqualTo(result);
    }

    @DisplayName("Operation.MINUS는 첫번째 인자에서 두번째 인자의 값을 뺀 값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4,3,1", "3,2,1", "1,2,-1"})
    void minusTest(int a, int b, int result) {
        assertThat(Operator.MINUS.result(a, b)).isEqualTo(result);
    }

    @DisplayName("Operation.DIVIDE 첫번째 인자를 두번째 인자로 나눗셈 한 값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0,1,0", "1,0,0", "1,2,0", "10,2,5"})
    void divideTest(int a, int b, int result) {
        assertThat(Operator.DIVIDE.result(a, b)).isEqualTo(result);
    }

    @DisplayName("Operation.MULTIPLY 첫번째 인자와 두번째 인자를 곱셈 한 값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "0,0,0", "10,10,100"})
    void multiplyTest(int a, int b, int result) {
        assertThat(Operator.MULTIPLY.result(a, b)).isEqualTo(result);
    }
}
