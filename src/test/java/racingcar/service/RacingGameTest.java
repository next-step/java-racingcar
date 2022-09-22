package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("참여한 자동차 수 확인")
    @Test
    void join() {
        Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));

        RacingGame game = new RacingGame();
        game.join(cars);

        assertThat(game.joinCount()).isEqualTo(3);
    }

    @DisplayName("모두 출발하는 경우")
    @Test
    void race() {
        Cars cars = CarFactory.createCars(2);
        RacingGame game = new RacingGame(() -> true);

        game.join(cars);
        game.race(2);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(3);
        assertThat(movedCars.get(1).position()).isEqualTo(3);
    }

    @DisplayName("모두 출발하지 못한 경우")
    @Test
    void raceNoMove() {
        Cars cars = CarFactory.createCars(2);
        RacingGame game = new RacingGame(() -> false);

        game.join(cars);
        game.race(2);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(1);
        assertThat(movedCars.get(1).position()).isEqualTo(1);
    }
}
