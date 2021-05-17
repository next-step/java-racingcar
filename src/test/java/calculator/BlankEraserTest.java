package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlankEraserTest {
    @Test
    void 공백지우기() {
        String test = "3 + 2";
        BlankEraser blankEraser = new BlankEraser();
        String[] results = blankEraser.erase(test);
        assertThat(results).contains("3", "+", "2");
    }
}