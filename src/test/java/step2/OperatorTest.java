package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorTest {

    @Test
    @DisplayName("덧셈 연산 테스트")
    void checkPlusTest() {
        assertThat(Operator.calculate(4, "+", 3))
                .isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    void checkMinusTest() {
        assertThat(Operator.calculate(4, "-", 3))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    void checkMultipleTest() {
        assertThat(Operator.calculate(4, "*", 3))
                .isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 연산 테스트")
    void checkDivideTest() {
        assertThat(Operator.calculate(4, "/", 3))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("나눗셈 연산시 0으로 나눌 때 에러 테스트")
    void checkDivideZeroErrorTest() {
        assertThrows(IllegalArgumentException.class,
                () -> Operator.calculate(4, "/", 0));
    }

}