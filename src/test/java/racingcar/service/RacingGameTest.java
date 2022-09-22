package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.repository.RacingCarTable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("참여한 자동차 수 확인")
    @Test
    void join() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b"), new Car("c")));

        RacingGame game = new RacingGame(new RacingCarTable());
        game.join(cars);

        assertThat(game.joinCount()).isEqualTo(3);
    }

    @DisplayName("모두 출발하는 경우")
    @Test
    void race() {
        Cars cars = CarFactory.createCars("noose,pobi");
        RacingGame game = new RacingGame(new RacingCarTable(), () -> true);

        game.join(cars);
        game.race(2);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(new Position(3));
        assertThat(movedCars.get(1).position()).isEqualTo(new Position(3));
    }

    @DisplayName("모두 출발하지 못한 경우")
    @Test
    void raceNoMove() {
        Cars cars = CarFactory.createCars("noose,pobi");
        RacingGame game = new RacingGame(new RacingCarTable(), () -> false);

        game.join(cars);
        game.race(2);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(new Position());
        assertThat(movedCars.get(1).position()).isEqualTo(new Position());
    }
}
