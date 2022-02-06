package racinggame.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCar;
import racinggame.domain.Trial;

class RacingGameControllerTest {

    private final RacingGameController controller = new RacingGameController();

    @Test
    void getRacingCars() {
        final String userInput = "car1, car2";

        final List<RacingCar> racingCars = controller.getRacingCars(userInput).get();

        assertThat(racingCars.size()).isEqualTo(2);
        assertThat(racingCars.get(0).getName()).isEqualTo("car1");
        assertThat(racingCars.get(1).getName()).isEqualTo("car2");
    }

    @Test
    void getTrial() {
        final String userInput = "5";

        final Trial trial = controller.getTrial(userInput);
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
