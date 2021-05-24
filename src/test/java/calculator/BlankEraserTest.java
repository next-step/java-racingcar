package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlankEraserTest {
    @Test
    void 공백지우기() {
        BlankEraser blankEraser = new BlankEraser();
        String test = "3 + 2";
        String[] results = blankEraser.erase(test);
        assertThat(results).contains("3", "+", "2");

        String test2 = "33 + 2";
        String[] results2 = blankEraser.erase(test2);
        assertThat(results2).contains("33", "+", "2");
    }
}