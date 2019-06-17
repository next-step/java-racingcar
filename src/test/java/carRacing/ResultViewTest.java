package carRacing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @Test
    void chartPrintTest() {
        ResultView view = new ResultView();
        assertThat(view.recordToString(5)).isEqualTo("-----");
        assertThat(view.recordToString(3)).isEqualTo("---");
    }
}