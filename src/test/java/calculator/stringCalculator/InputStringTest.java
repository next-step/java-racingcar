package calculator.stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringTest {

    @Test
    @DisplayName("null일 경우 0 반환")
    void nullTest() {
        InputString inputString = InputString.of(null, null);

        int result = inputString.calculate();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열일 경우 0 반환")
    void blankTest() {
        InputString inputString = InputString.of("", null);

        int result = inputString.calculate();

        assertThat(result).isEqualTo(0);
    }

}