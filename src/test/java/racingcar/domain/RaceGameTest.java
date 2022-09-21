package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {

    @DisplayName("참여한 자동차 수 확인")
    @Test
    void join() {
        Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));

        RaceGame game = new RaceGame(cars);

        assertThat(game.joinCount()).isEqualTo(3);
    }

    @DisplayName("모두 출발하는 경우")
    @Test
    void race() {
        Cars cars = CarFactory.createCars(2);
        RaceGame game = new RaceGame(cars, () -> true);

        game.race();
        game.race();

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(2);
        assertThat(movedCars.get(1).position()).isEqualTo(2);
    }

    @DisplayName("모두 출발하지 못한 경우")
    @Test
    void raceNoMove() {
        Cars cars = CarFactory.createCars(2);
        RaceGame game = new RaceGame(cars, () -> false);

        game.race();
        game.race();

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(0);
        assertThat(movedCars.get(1).position()).isEqualTo(0);
    }
}
