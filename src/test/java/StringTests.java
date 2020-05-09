import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTests {
    @DisplayName("String '1,2'를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void stringSplitTest() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }
}
