package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorUtilsTest {

    @Test
    @DisplayName("BLANK 값 테스트")
    void blank() {
        assertThat(CalculatorUtils.BLANK).isEqualTo(" ");
    }


}
