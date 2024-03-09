package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void splitAndSum_빈문자이거나_null이면_0을_반환() {
        // Given
        String empty = "";
        String nullTest = null;
        int expected = 0;

        // When & Then
        assertThat(Calculator.splitAndSum(empty)).isEqualTo(expected);
        assertThat(Calculator.splitAndSum(nullTest)).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        // Given
        int expected = 6;
        String text = "1,2,3";

        // When & Then
        assertThat(Calculator.splitAndSum(text)).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_콜론구분자() {
        // Given
        int expected = 6;
        String text = "1:2:3";

        // When & Then
        assertThat(Calculator.splitAndSum(text)).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_콜론과쉼표구분자() {
        // Given
        int expected = 6;
        String text = "1,2:3";

        // When & Then
        assertThat(Calculator.splitAndSum(text)).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        // Given
        int expected = 6;
        String text = "1,2:3";

        // When & Then
        assertThat(Calculator.splitAndSum(text)).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_custom() {
        // Given
        int expected = 6;
        String text = "//a\n1a2a3a";
        // When & Then
        assertThat(Calculator.splitAndSum(text)).isEqualTo(expected);
    }

    @Test
    public void 음수값이들어오면_예외를던진다() {
        String text = "-1,2:3";
        assertThatThrownBy(() -> Calculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 숫자가아닌값이들어오면_예외를던진다() {
        String text = "abc,2:3";
        assertThatThrownBy(() -> Calculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
