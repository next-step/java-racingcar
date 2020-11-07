package racing.view;

import org.junit.jupiter.api.Test;
import racing.view.to.RacingInputTO;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingInputViewTest {
    private static final String DRIVERS = "Lewis Hamilton,Valtteri Bottas,Max Verstappen";
    private static final int MAX_ROUND = 5;

    @Test
    void testInputView() {
        String sample = DRIVERS + "\n" + MAX_ROUND;

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);


        RacingInputView racingInputView = new RacingInputView();
        RacingInputTO racingInput = racingInputView.getRacingInput();

        assertThat(racingInput).isNotNull();
        assertThat(racingInput.getDrivers()).containsAll(Arrays.asList(DRIVERS.split(",")));
        assertThat(racingInput.getMaxRounds()).isEqualTo(MAX_ROUND);

    }
}
