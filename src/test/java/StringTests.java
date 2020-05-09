import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTests {
    @DisplayName("String '1,2'를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void stringSplitWithTwoNumbers() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1,2".split(",")).contains("2");
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("String '1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void stringSplitWithOneNumber() {
        assertThat("1".split(",")).contains("1");
        assertThat("1".split(",")).containsExactly("1");
    }
}
