package camp.nextstep.edu.rebellion.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculationOperatorTest {
    @DisplayName("사칙연산이 정상적으로 수행되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "+:10:5:15",
            "-:10:5:5",
            "*:10:5:50",
            "/:10:5:2",
    }, delimiter = ':')
    public void calculationOperationTest(String operator, int val1, int val2, int expected) {
        // when
        int result = CalculationOperator.of(operator).operation(val1, val2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("0으로 나눌 경우 예외 발생")
    @Test
    public void divideZeroTest() {
        // when & then
        assertThatThrownBy(() -> CalculationOperator.DIV.operation(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }

    @DisplayName("지원하지 않는 연산자일 경우 예외 발생")
    @Test
    public void notSupportedOperatorTest() {
        // given
        String operator = "(";

        // when & then
        assertThatThrownBy(() -> CalculationOperator.of(operator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자 입니다 : " + operator);
    }
}
