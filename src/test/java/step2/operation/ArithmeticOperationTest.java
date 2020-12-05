package step2.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ArithmeticOperationTest {

    @Test
    @DisplayName("사칙연산 테스트")
    void arithmeticOperationTest() {
        assertThat(new PlusOperation().apply(5, 10)).isEqualTo(15);
        assertThat(new MinusOperation().apply(9, 3)).isEqualTo(6);
        assertThat(new MultiplicationOperation().apply(5, 3)).isEqualTo(15);
        assertThat(new DivisionOperation().apply(8, 4)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 실패 테스트")
    void divisionOperationFailTest() {
        assertThatThrownBy(() -> new DivisionOperation().apply(9, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다");

        assertThatThrownBy(() -> new DivisionOperation().apply(8, 6))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("나눗셈은 결괏값이 정수로 떨어지는 값이어야 합니다");
    }
}