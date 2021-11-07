package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MyNumberTest {
    @Test
    @DisplayName("덧셈")
    public void add() {
        assertThat(new MyNumber(1).add(new MyNumber(2)))
                .isEqualTo(new MyNumber(3));
    }

    @Test
    @DisplayName("뺄셈")
    public void subtraction() {
        assertThat(new MyNumber(1).subtraction(new MyNumber(2)))
                .isEqualTo(new MyNumber(-1));
    }

    @Test
    @DisplayName("곱셈")
    public void multiplication() {
        assertThat(new MyNumber(1).multiplication(new MyNumber(2)))
                .isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("나눗셈")
    public void division() {
        assertThat(new MyNumber(1).division(new MyNumber(2)))
                .isEqualTo(new MyNumber(0));
    }

    @Test
    @DisplayName("나눗셈 분모 예외")
    public void divisionWithException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MyNumber(1).division(new MyNumber(0)))
                .withMessage("denominator cannot used zero.");
    }
}
