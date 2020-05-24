package camp.nextstep.edu.nextstep8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationOperatorTypeTest {

    @DisplayName("두 수의 덧셈을 테스트 합니다")
    @Test
    public void addTest() {
        // given
        int val1 = 10;
        int val2 = 20;
        int result = 0;

        // when
        result = CalculationOperatorType.ADD.operation(val1, val2);

        // then
        assertThat(result).isEqualTo(val1 + val2);
    }

    @DisplayName("두 수의 뺄셈을 테스트 합니다")
    @Test
    public void subTest() {
        // given
        int val1 = 10;
        int val2 = 20;
        int result = 0;

        // when
        result = CalculationOperatorType.SUB.operation(val1, val2);

        // then
        assertThat(result).isEqualTo(val1 - val2);
    }

    @DisplayName("두 수의 곱셈을 테스트 합니다")
    @Test
    public void mulTest() {
        // given
        int val1 = 10;
        int val2 = 20;
        int result = 0;

        // when
        result = CalculationOperatorType.MUL.operation(val1, val2);

        // then
        assertThat(result).isEqualTo(val1 * val2);
    }

    @DisplayName("두 수의 나눗셈을 테스트 합니다")
    @Test
    public void divTest() {
        // given
        int val1 = 20;
        int val2 = 10;
        int result = 0;

        // when
        result = CalculationOperatorType.DIV.operation(val1, val2);

        // then
        assertThat(result).isEqualTo(val1 / val2);
    }

    @DisplayName("두 수를 나눗셈할 때 0 으로 나눌 수 없습니다")
    @Test
    public void divZeroTest() {
        // given
        int val1 = 20;
        int val2 = 0;
        int result = 0;

        assertThatThrownBy(()->{
            // when
             CalculationOperatorType.DIV.operation(val1, val2);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }
}