package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void splitInputTest() {
        assertThat(StringUtils.splitInput(" ")).containsExactly();
        assertThat(StringUtils.splitInput("2 + 3 * 4 / 2")).containsExactly("2","+","3","*","4","/","2");
    }
}
