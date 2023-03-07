package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    @Test
    @DisplayName("위치가 가장 높은 차가 우승자가 된다.")
    void getRacingWinners() {
        Car carA = new Car("carA", 1);
        Car carB = new Car("carB", 2);
        Car carC = new Car("carC", 5);
        Car carD = new Car("carD", 5);
        List<Car> racingCars = List.of(carA, carB, carC, carD);

        RacingGame racingGame = new RacingGame(racingCars, new Random());
        List<Car> racingWinners = racingGame.getRacingWinners();

        Assertions.assertThat(racingWinners).containsExactly(carC, carD);
    }

}