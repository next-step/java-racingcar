package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @Test
    @DisplayName("연산자에 따른 계산 테스트")
    void repeatCalculate() {
        int sum = 0;
        sum = Operator.calculate("+", sum, 2);
        sum = Operator.calculate("*", sum, 3);
        sum = Operator.calculate("/", sum, 3);
        // 간단하게 테스트할 수 있는 방법은?

        assertThat(sum).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("연산자 테스트")
    @ValueSource(strings = {"#", "A"})
    void operatorException(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Operator.getOperator(value);
        }).withMessage("올바른 연산자가 아닙니다.");
    }
}
