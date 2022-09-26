package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringLearningTest {
    @Test
    void 문자열분리() {
        String input = "1,2";

        assertThat(input.split(",")).contains("1", "2");
    }
}
