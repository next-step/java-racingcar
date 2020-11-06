package racing.view;

import org.junit.jupiter.api.Test;
import racing.view.to.RacingInputTO;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInputViewTest {
    private static final int MAX_MACHINE = 3;
    private static final int MAX_ROUND = 5;

    @Test
    public void testInputView() {
        String sample = MAX_MACHINE + "\n" + MAX_ROUND;

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);


        RacingInputView racingInputView = new RacingInputView();
        RacingInputTO racingInput = racingInputView.getRacingInput();

        assertThat(racingInput).isNotNull();
        assertThat(racingInput).extracting("maxMachines", "maxRounds").containsExactly(MAX_MACHINE, MAX_ROUND);

    }
}
