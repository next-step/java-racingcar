package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("입력 값이 null일 경우 IllegalArgumentException throw")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(null);
        });
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @Test
    void inputBlankTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate("");
        });
    }
}
