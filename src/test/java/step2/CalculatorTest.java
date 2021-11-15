package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    @Test
    @Order(1)
    void add() {
        // given
        Calculator c = new Calculator("");
        int op1 = 2, op2 = 3;

        // when
        // then
        assertThat(c.add(op1, op2)).isEqualTo(5);
    }

    @Test
    @Order(2)
    void subtract() {
        // given
        Calculator c = new Calculator("");
        int op1 = 2, op2 = 3;

        // when
        // then
        assertThat(c.subtract(op1, op2)).isEqualTo(-1);
    }

    @Test
    @Order(3)
    void multiply() {
        // given
        Calculator c = new Calculator("");
        int op1 = 2, op2 = 3;

        // when
        // then
        assertThat(c.multiply(op1, op2)).isEqualTo(6);
    }

    @Test
    @Order(4)
    void divide() {
        // given
        // when
        Calculator c = new Calculator("");
        int op1 = 6, op2 = 2;

        // then
        assertThat(c.divide(op1, op2)).isEqualTo(3);
    }

    @Test
    @Order(5)
    @DisplayName("입력값이 null 이거나 빈 공백문자인 경우 IllegalArgumentException")
    void t1() {
        Calculator c = new Calculator(" ");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calcExpr();
        });
    }

    @Test
    @Order(6)
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
    void noFourFundamentalArithmetic() {
        Calculator c = new Calculator("2 ^ 3");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calcExpr();
        });
    }

    @Test
    @Order(7)
    @DisplayName("수식 계산")
    void calcStringExpression() {
        Calculator c = new Calculator("2 + 3 * 4 / 2 - 6");
        assertThat(c.calcExpr()).isEqualTo(4);
    }
}