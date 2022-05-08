package racing_refactoring.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static RacingCars racingCars;

    @BeforeEach
    void setup() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        racingCars = new RacingCars(cars);
    }

    @DisplayName("자동차들을 움직여 이동한 것을 확인한다.")
    @Test
    void racing() {

        RacingGame racingGame = new RacingGame(racingCars);
        assertThat(racingGame.racing(new SequentialMovingStrategy())).isNotNull();
    }
}
