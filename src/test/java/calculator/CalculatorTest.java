package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void splitAndAddString_null_또는_빈문자() {
        assertThat(StringAddCalculator.splitAndAddString(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndAddString("")).isEqualTo(0);
    }

    @Test
    public void splitAndAddString_숫자_하나() throws Exception {
        assertThat(StringAddCalculator.splitAndAddString("3")).isEqualTo(3);
    }

    @Test
    public void splitAndAddString_쉼표_구분자() throws Exception {
        assertThat(StringAddCalculator.splitAndAddString("1,2")).isEqualTo(3);
    }

    @Test
    public void splitAndAddString_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(StringAddCalculator.splitAndAddString("1,2:3")).isEqualTo(6);
    }

    @Test
    public void splitAndAddString_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndAddString("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndAddString_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndAddString("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
