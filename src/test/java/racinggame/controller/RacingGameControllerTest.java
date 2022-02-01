package racinggame.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCars;
import racinggame.domain.Trial;
import racinggame.view.InputView;

class RacingGameControllerTest {

    private final RacingGameController controller = new RacingGameController(new InputView());

    @Test
    void getRacingCars() {
        final String userInput = "car1, car2";
        final InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        final RacingCars racingCars = controller.getRacingCars();

        assertThat(racingCars.get().size()).isEqualTo(2);
        assertThat(racingCars.get().get(0).getName()).isEqualTo("car1");
        assertThat(racingCars.get().get(1).getName()).isEqualTo("car2");
    }

    @Test
    void getTrial() {
        final String userInput = "5";
        final InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        final Trial trial = controller.getTrial();
        assertThat(trial.getValue()).isEqualTo(5);
    }

    @ExpectSystemExit
    @Test
    void checkIsRestart_q를_입력하면_종료된다() {
        // given
        final InputStream inputStream = new ByteArrayInputStream("q".getBytes());
        System.setIn(inputStream);

        // then
        controller.checkIsRestart();
    }
}
