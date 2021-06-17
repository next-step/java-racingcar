package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {
    @DisplayName("입력값을 받아서 더할 수 있다.")
    @Test
    void addTest() {
        assertThat(Operator.findSymbol("+").calculate(2, 3)).isEqualTo(5);
    }

    @DisplayName("입력값을 받아서 뺄수 있다.")
    @Test
    void subtractTest() {
        assertThat(Operator.findSymbol("-").calculate(6, 4)).isEqualTo(2);
    }

    @DisplayName("입력값을 받아서 곱할수 있다.")
    @Test
    void multiplyTest() {
        assertThat(Operator.findSymbol("*").calculate(2, 3)).isEqualTo(6);
    }

    @DisplayName("입력값을 받아서 나눌수 있다.")
    @Test
    void divideTest() {
        assertThat(Operator.findSymbol("/").calculate(6, 3)).isEqualTo(2);
    }

    @DisplayName("모든 숫자는 0으로 나눌 수 없다.")
    @Test
    void divideZeroTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.findSymbol("/").calculate(6, 0));
    }
}
