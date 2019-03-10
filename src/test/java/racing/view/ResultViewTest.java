package racing.view;

import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    public void test_generateHyphen() {
        assertThat(ResultView.convertToChars(Arrays.asList(1, 2, 3)))
                .isEqualTo(
                        "-\n" +
                        "--\n" +
                        "---\n");
    }
}