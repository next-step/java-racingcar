import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("\"1,2\" 분리")
    void splitWithRestChar(){
        String[] splits = "1,2".split(",");

        assertThat(splits).contains("1", "2");
    }
}
