import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("1,2 ,로 분리")
    void splitWithRestChar(){
        String[] splits = "1,2".split(",");

        assertThat(splits).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 ,로 분리")
    void splitWithRestChar_noRestChar(){
        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }
}
