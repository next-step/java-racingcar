package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("입력값이 null 예외처리")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(null);
        });
    }

    @DisplayName("입력값이 공백 예외처")
    @Test
    void inputEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator("");
        });
    }
}
