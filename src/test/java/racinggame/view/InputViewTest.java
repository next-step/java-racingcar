package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void carNames_정상_입력() {
        // given
        final String userInput = "car1,car2";
        final InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // when
        final String inputCarNames = InputView.inputCarNames();

        // then
        assertThat(inputCarNames).isEqualTo(userInput);
    }

    @Test
    void 시도횟수_정상_입력() {
        // given
        final String inputTrial = "5";
        final InputStream inputStream = new ByteArrayInputStream(inputTrial.getBytes());
        System.setIn(inputStream);

        // when
        final String trial = InputView.inputTrial();

        // then
        assertThat(trial).isEqualTo(inputTrial);
    }
}
