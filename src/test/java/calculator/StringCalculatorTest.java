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

    @DisplayName("\"1\" 을 입력하면 1을 반환한다")
    @Test
    void oneInput() {
        int result = StringCalculator.cal("1");
        assertThat(result).isEqualTo(1);
    }
}
