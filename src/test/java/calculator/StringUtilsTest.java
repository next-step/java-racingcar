package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void splitInputTest() {
        assertThat(StringUtils.splitInput(" ")).containsExactly(" ");
    }
}
