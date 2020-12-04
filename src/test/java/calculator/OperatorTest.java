package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @DisplayName("사칙연산 이외의 연산자를 전달하면 에러 발생")
    @Test
    public void invalidSymbol() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.calculate(1, 2, "("));
    }

}
