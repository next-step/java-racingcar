package caculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculationTest {
    @Test
    public void add_delimiter_comma() {
        int actual = StringCalculation.add("1,2,3");
        assertThat(actual).isEqualTo(6);
    }
}
