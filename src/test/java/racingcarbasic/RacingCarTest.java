package racingcarbasic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class RacingCarTest {

    @Test
    void 전진(int num) {
        RacingCars racingCars = RacingCars.of(5, () -> true);
        racingCars.moveCars();

        assertThat(racingCars.getCarList()).allMatch(car -> car.getStep() == 1);
    }

    @Test
    void 멈춤() {
        RacingCars racingCars = RacingCars.of(5, () -> false);
        racingCars.moveCars();

        assertThat(racingCars.getCarList()).allMatch(car -> car.getStep() == 0);
    }

    @Test
    void name() {
        InputView inputView = new InputView();
        inputView.getCarName();
    }
}
