package caculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculationTest {
    @Test
    public void add_delimiter_comma() {
        int actual = StringCalculation.add("1,2,3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void add_delimiter_colon() {
        int actual = StringCalculation.add("1,2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void add_empty_or_null() {
        int actual = StringCalculation.add("");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void add_custom_delimiter() {
        int actual = StringCalculation.add("//;\n1;2;3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void add_not_positive_number() {
        assertThatThrownBy(() -> StringCalculation.add("-1,2,3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringCalculation.add("a,2,3")).isInstanceOf(RuntimeException.class);
    }
}
