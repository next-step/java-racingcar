package racing.view;

import org.junit.jupiter.api.Test;
import utils.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultViewTest {

    @Test
    void testResultView() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RacingResultView racingResultView = new RacingResultView();
        HashMap<Integer, Integer> lapMapStatus = new HashMap<>();
        lapMapStatus.put(1, 1);
        lapMapStatus.put(2, 1);
        lapMapStatus.put(3, 1);
        racingResultView.ready(lapMapStatus);

        assertThat(outContent.toString()).contains(StringUtils.repeat("-\n", 3));
    }
}
