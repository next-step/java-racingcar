package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class OperatorTypeTest {

    @DisplayName("4칙 연산 테스트")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"2,3,'+',5", "5,2,'-',3", "3,7,'*',21", "6,3,'/',2"})
    void operate(int first, int second, String operator, int expected) {
        int result = OperatorType.operate(first, second, operator);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("0으로 나눌 시 ArithmeticException 발생")
    @Test
    void divide_ThrowsArithmeticException_IfDivideByZero() {
        OperatorType divide = OperatorType.DIVIDE;
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> divide.operate(6, 0, "/"));
    }

    @DisplayName("기호에 따라 Operator Type을 찾기")
    @ParameterizedTest(name = "{index} {displayName}")
    @MethodSource("parametersProvider")
    void find_OperatorType(String operator, OperatorType expected) {
        OperatorType operatorType = OperatorType.find(operator);
        assertThat(operatorType).isEqualTo(expected);
    }

    @DisplayName("없는 기호를 operate 할 때 IllegalArgumentException 발생")
    @Test
    void find_ThrowsIllegalArgumentException_IfOperatorArgumentIsInvalid() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> OperatorType.operate(2, 3, "@")
        );
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.arguments("+", OperatorType.PLUS),
                Arguments.arguments("-", OperatorType.MINUS),
                Arguments.arguments("*", OperatorType.MULTIPLY),
                Arguments.arguments("/", OperatorType.DIVIDE)
        );
    }


}
