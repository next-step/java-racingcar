import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTest {

    @Test
    @DisplayName("step 1 - split test")
    void step1() {
        String str = "1,2";
        String[] result = str.split(",");
        assertThat(result).contains("1", "2");

        assertThat("1".split(",")).containsExactly("1");
    }
}
