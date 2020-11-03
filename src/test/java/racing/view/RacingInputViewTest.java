package racing.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInputViewTest {
    @Test
    public void testInputView() {
        String sample = "3\n5";

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);


        RacingInputView racingInputView = new RacingInputView();
        racingInputView.view();

        assertThat(racingInputView.getGrandPrixId()).isNotNull();
    }
}
