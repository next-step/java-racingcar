import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @ParameterizedTest
    @DisplayName("계산")
    @CsvSource(value = {"1:+:2:3", "3:-:1:2", "4:*:2:8", "6:/:2:3"}, delimiter = ':')
    void calculator(double leftNumber, String operator, double rightNumber, int result) {
        assertThat(Operator.of(operator).calculator(leftNumber, rightNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("연산자 검사")
    @ValueSource(strings = {"a"})
    void isOperator (String operator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(operator))
                .withMessage("연산자가 아닙니다.");
    }
}