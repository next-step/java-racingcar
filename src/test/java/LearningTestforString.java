import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("step 01 - Learning test for String class")
public class LearningTestforString {
    @DisplayName("split \"1, 2\" with \",\"")
    @Test
    void testSplitTwoNumbers() {
        String testString = "1,2";
        String[] splitResult = testString.split(",");
        assertThat(splitResult)
                .contains("1", "2")
                .containsExactly("1", "2");
    }

    @DisplayName("split \"1\" with \",\"")
    @Test
    void testSplitOneNumber() {
        String testString = "1";
        String[] splitResult = testString.split(",");
        assertThat(splitResult)
                .hasSize(1)
                .contains("1");
    }
}
