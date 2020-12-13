package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void add() {
        assertThat(Operator.ADD.calculate(8, 5)).isEqualTo(13);
    }

    @Test
    void subtract() {
        assertThat(Operator.SUBTRACT.calculate(8, 5)).isEqualTo(3);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.calculate(8, 5)).isEqualTo(40);
    }

    @Test
    void division() {
        assertThat(Operator.DIVISION.calculate(8, 5)).isEqualTo(1);
    }

    @Test
    void division_zero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.DIVISION.calculate(5, 0);
        }).withMessage("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("입력받은 Operator에 속하지 않는 문자열일 경우 Exception을 반환한다.")
    void assertOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator operator = Operator.from("$");
        }).withMessage("사칙 연산자에 해당하는 기호가 아닙니다.");
    }
}
