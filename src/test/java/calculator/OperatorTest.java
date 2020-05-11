package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void plusTest() {
        assertThat(Operator.PLUS.calculate("+", 1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minusTest() {
        assertThat(Operator.MINUS.calculate("-", 7, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() {
        assertThat(Operator.MULTIPLY.calculate("*", 7, 2)).isEqualTo(14);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divisionTest() {
        assertThat(Operator.DIVISION.calculate("/", 14, 2)).isEqualTo(7);
    }
}
