package calculator;

import caculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {
    Operator operator = new Operator();

    @Test
    @DisplayName("Operator 덧셈 테스트")
    void testOperatorAddition() {
        double actual = operator.calculate(5, "+", 6);
        assertThat(actual).isEqualTo(11);
    }

    @Test
    @DisplayName("Operator 뺄셈 테스트")
    void testOperatorSubtraction() {
        double actual = operator.calculate(45, "-", 44);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("Operator 곱셈 테스트")
    void testOperatorMultiply() {
        double actual = operator.calculate(4, "*", 2);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    @DisplayName("Operator 나눗셈 테스트")
    void testOperatorDivision() {
        double actual = operator.calculate(63, "/", 7);
        assertThat(actual).isEqualTo(9);
    }

    @Test
    @DisplayName("Operator 입력 값이 숫자가 아닐 경우 IllegalArgumentException")
    void testExpectedExceptionInputType() {
        assertThatThrownBy(() -> operator.calculate(5, "-", "S"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
