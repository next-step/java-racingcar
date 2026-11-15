package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @DisplayName("\"\" 를 입력하면 0을 반환한다")
    @Test
    void emptyInput() {
        int result = StringCalculator.cal("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 을 입력하면 0을 반환한다")
    @Test
    void nullInput() {
        int result = StringCalculator.cal(null);
        assertThat(result).isEqualTo(0);
    }
}
