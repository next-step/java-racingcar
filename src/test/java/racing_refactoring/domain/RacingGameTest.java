package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("자동차들을 움직여 이동한 것을 확인한다.")
    @Test
    void racing() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        RacingCars racingCars = new RacingCars(cars);

        RacingGame racingGame = new RacingGame(racingCars, 1);
        assertThat(racingGame.racing()).isNotNull();
    }
}
