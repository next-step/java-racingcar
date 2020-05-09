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
                .containsExactly("1","2");
    }
}
