package racing.view;

import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import utils.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultViewTest {

    @Test
    public void testResultView() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RacingResultView racingResultView = new RacingResultView();
        racingResultView.ready(new GrandPrix(3, 5));

        assertThat(outContent.toString()).contains(StringUtils.repeat("-\n", 3));
    }
}
